package com.example.mymapkit;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.LocationListener;
import android.location.LocationProvider;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mymapkit.DB.DBHelper;
import com.example.mymapkit.DB.DBManager;
import com.google.android.gms.location.LocationRequest;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.GeoObjectCollection;
import com.yandex.mapkit.MapKit;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.RequestPoint;
import com.yandex.mapkit.RequestPointType;
import com.yandex.mapkit.directions.DirectionsFactory;
import com.yandex.mapkit.directions.driving.DrivingOptions;
import com.yandex.mapkit.directions.driving.DrivingRoute;
import com.yandex.mapkit.directions.driving.DrivingRouter;
import com.yandex.mapkit.directions.driving.DrivingSession;
import com.yandex.mapkit.directions.driving.VehicleOptions;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.layers.GeoObjectTapEvent;
import com.yandex.mapkit.layers.GeoObjectTapListener;
import com.yandex.mapkit.layers.ObjectEvent;
import com.yandex.mapkit.location.LocationManager;
import com.yandex.mapkit.map.CameraListener;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.map.CameraUpdateReason;
import com.yandex.mapkit.map.CompositeIcon;
import com.yandex.mapkit.map.GeoObjectSelectionMetadata;
import com.yandex.mapkit.map.IconStyle;
import com.yandex.mapkit.map.InputListener;
import com.yandex.mapkit.map.Map;
import com.yandex.mapkit.map.MapObject;
import com.yandex.mapkit.map.MapObjectCollection;
import com.yandex.mapkit.map.MapObjectTapListener;
import com.yandex.mapkit.map.PlacemarkMapObject;
import com.yandex.mapkit.map.RotationType;
import com.yandex.mapkit.map.VisibleRegionUtils;
import com.yandex.mapkit.mapview.MapView;
import com.yandex.mapkit.search.PlaceInfo;
import com.yandex.mapkit.search.Response;
import com.yandex.mapkit.search.SearchFactory;
import com.yandex.mapkit.search.SearchManager;
import com.yandex.mapkit.search.SearchManagerType;
import com.yandex.mapkit.search.SearchOptions;
import com.yandex.mapkit.search.Session;
import com.yandex.mapkit.transport.masstransit.PedestrianRouter;
import com.yandex.mapkit.user_location.UserLocationLayer;
import com.yandex.mapkit.user_location.UserLocationObjectListener;
import com.yandex.mapkit.user_location.UserLocationView;
import com.yandex.runtime.Error;
import com.yandex.runtime.i18n.I18nManagerFactory;
import com.yandex.runtime.image.ImageProvider;
import com.yandex.runtime.network.NetworkError;
import com.yandex.runtime.network.RemoteError;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity  implements UserLocationObjectListener, Session.SearchListener, DrivingSession.DrivingRouteListener,
        GeoObjectTapListener, InputListener {

    //Создаем обьект карты
    private MapView mapview;
    // Создаем локацию для пользователя
    private UserLocationLayer userLocationLayer;

    private ImageView mGps;
    private ImageView museum_db, restaurant_db;

    private Boolean followUserLocation = false;
    private CameraListener cameraListener;
    private Point routeStartLocation;

    private EditText searchEdit;
    private SearchManager searchManager;
    private  ImageView ic_close;
    private Session searchSession;
    private Session.SearchListener mSearchPointListener;
    int const_search_state = 1;

    private LocationManager locationManager;
    private LocationProvider locationProvider;
    private LocationListener locationListener;
    private LocationRequest locationRequest;
    int butt_counter = 1;
    int butt_counter2 = 1;
    private PlacemarkMapObject mus_db;

    private MapObjectCollection mapObjects;
    private DrivingRouter drivingRouter;
    private DrivingSession drivingSession;

    final int RESULT_CODE_MUSEUM_POINT = 100;
    final int RESULT_CODE_Restaurant_POINT = 111;
    public LinearLayout L_lmain;

    final int RESULT_CODE_ROUTE_1 = 101;
    final int RESULT_CODE_ROUTE_2 = 102;
    final int RESULT_CODE_ROUTE_3 = 103;
    final int RESULT_CODE_ROUTE_4 = 104;


    Point point_save;

    private Button button_routes;
    private String Route_1 = "route 1";
//    final int menu_id_1 = 1;
//    final int menu_id_2 = 2;
//    final int menu_id_3 = 3;

//   private Bitmap bitmap = Bitmap.createBitmap(100, 100,
//            Bitmap.Config.ARGB_8888);

//    public void requestLocationUpdates (long minTimeMs,
//                                        float minDistanceM,
//                                        Criteria criteria,
//                                        LocationListener listener,
//                                        Looper looper){
//
//         long milliseconds = 5000; // 5 seconds
//    float minimusDistance = 5.5F; // 5.5m distance from current location
//    locationManager.requestLocationUpdates(locationProvider, milliseconds, minimusDistance, locationListener);
//    }


    private void submitQuery(String query) {
        searchSession = searchManager.submit(
                query,
                VisibleRegionUtils.toPolygon(mapview.getMap().getVisibleRegion()),
                new SearchOptions(),
                 this);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //ключ апи
        MapKitFactory.setApiKey("8c2094f3-0cf6-42e5-97a8-2711ec731846");

        //инициализируем класс
        MapKitFactory.initialize(this);



        //меню маршрутов
        button_routes = (Button)findViewById(R.id.id_routes);
        // устанавливаем разметку
        setContentView(R.layout.activity_main);
        mapview = (MapView)findViewById(R.id.mapview);
        museum_db = (ImageView)findViewById(R.id.id_museum);
        restaurant_db = (ImageView)findViewById(R.id.id_restaurant);
        mGps = (ImageView)findViewById(R.id.id_gps);

        // разрешение на поворот камеры
        mapview.getMap().setRotateGesturesEnabled(true);
        //////
        mapview.getMap().addTapListener(this);
        mapview.getMap().addInputListener(this);

        //инициализация поиска
        SearchFactory.initialize(this);
        searchEdit = (EditText)findViewById(R.id.input_search);
        searchManager = SearchFactory.getInstance().createSearchManager(SearchManagerType.COMBINED);
        ic_close = (ImageView) findViewById(R.id.ic_close);

        L_lmain = (LinearLayout)findViewById(R.id.Lay_mus_close);

// перемещение камеры в стартовую точку
        mapview.getMap().move(
                new CameraPosition(new Point(59.9386, 30.3141), 12.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 0),
                null);

//г инициализация определения геолокации
        MapKit mapKit = MapKitFactory.getInstance();
        mapview.getMap().setRotateGesturesEnabled(true);
        userLocationLayer = mapKit.createUserLocationLayer(mapview.getMapWindow());
        userLocationLayer.setVisible(true);
        userLocationLayer.setHeadingEnabled(true);
        userLocationLayer.setObjectListener((UserLocationObjectListener) MainActivity.this);
        followUserLocation = true;

        cameraUserPosition();
        museum_db.setEnabled(false);
        restaurant_db.setEnabled(false);

        new CountDownTimer(2000, 1000) {

            public void onTick(long millisUntilFinished) {
                Toast.makeText(MainActivity.this, "Please Wait " + (millisUntilFinished / 1000), Toast.LENGTH_SHORT).show();
            }

            public void onFinish() {
                Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();
                cameraUserPosition();
                museum_db.setEnabled(true);
                restaurant_db.setEnabled(true);
            }

        }.start();




// обработчик изменение геолокации
        cameraListener = new CameraListener() {
            @Override
            public void onCameraPositionChanged(@NonNull Map map, @NonNull CameraPosition cameraPosition, @NonNull CameraUpdateReason cameraUpdateReason, boolean b) {
                if (b) {
                    if (followUserLocation) {
                        setAnchor();
                    }
                } else {
                    if (!followUserLocation) {
                        noAnchor();
                    }
                }
            }
        };
//        PedestrianRouter pedestrianRouter



        // нажатие на кнопку определения местоположения
        mGps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cameraUserPosition();

            }
        });
        DBManager dbManager = new DBManager(this);

        dbManager.Open_Db();
        Log.d("mLog","База открылась");
        dbManager.Insert_Mus();
        dbManager.Insert_Res();
        Log.d("mLog","Данные добавились");
        // загрузка музеев
        museum_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (butt_counter == 1) {
            mapview.getMap().move(
                    new CameraPosition(new Point(59.9386, 30.3141), 12.0f, 0, 0),
                    new Animation(Animation.Type.SMOOTH, 1),
                    null);


                    Cursor cursor = dbManager.db.query(DBHelper.TABLE_MUSEUMS, null, null , null, null, null, null);
                    if (cursor.moveToFirst()){

                        int Mus_id = cursor.getColumnIndex(DBHelper.Mus_ID);
                        int Mus_Name = cursor.getColumnIndex(DBHelper.Museum_NAME);
                        String Museum_Info = String.valueOf(cursor.getColumnIndex(DBHelper.Museum_INFO));
                        String Museum_Address = String.valueOf(cursor.getColumnIndex(DBHelper.Museum_ADDRESS));
                        int Museum_Latitude = cursor.getColumnIndex(DBHelper.Museum_LATITUDE);
                        int Museum_Longitude = cursor.getColumnIndex(DBHelper.Museum_LONGITUDE);

                        Log.d("mLog","Широта "+ Museum_Latitude + "Долгота " + Museum_Longitude);
                        Log.d("mLog","Взялллллллллллллллллллллллллллллллллллллллл");
                        Log.d("mLog",Mus_id +"айдиииииииииииииииииииииииии");
                        MapObjectCollection pointCollection = mapview.getMap().getMapObjects().addCollection();
                        pointCollection.addTapListener(mapObjectTapListener);
                        do {
                            double latitude = Double.parseDouble(cursor.getString(Museum_Latitude));
                            double longitude = Double.parseDouble(cursor.getString(Museum_Longitude));
                            Log.d("mLog","Широта "+ latitude + "Долгота " + longitude);
                            Point point = new Point(latitude, longitude);



                            PlacemarkMapObject placemarkMapObject = pointCollection.addPlacemark(point, ImageProvider.fromResource(MainActivity.this,
                                    R.drawable.loct));
                            placemarkMapObject.setUserData(cursor.getString(Mus_Name));
                            Log.d("mLog","Метка создалась");
                            Log.d("mLog",Mus_id +"айдиииииииииииииииииииииииии");
                            placemarkMapObject.addTapListener(mapObjectTapListener);

                        } while (cursor.moveToNext());
                    } else Log.d("mLog","0 rows");

                    butt_counter = 0;
                    cursor.close();
                }else{
                    mapview.getMap().getMapObjects().clear();
                    L_lmain.removeAllViews();
                    butt_counter = 1;
                    Log.d("mLog","База закрылась");
                }
            }
        });

        restaurant_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (butt_counter2 == 1) {
                    mapview.getMap().move(
                            new CameraPosition(new Point(59.9386, 30.3141), 12.0f, 0, 0),
                            new Animation(Animation.Type.SMOOTH, 1),
                            null);


                    Cursor cursor_r = dbManager.db.query(DBHelper.TABLE_RESTAURANTS_BARS, null, null , null, null, null, null);
                    if (cursor_r.moveToFirst()){

                        int Rest_id = cursor_r.getColumnIndex(DBHelper.Restaurant_ID);
                        int Rest_Name = cursor_r.getColumnIndex(DBHelper.Restaurant_NAME);
                        String Rest_Info = String.valueOf(cursor_r.getColumnIndex(DBHelper.Restaurant_INFO));
                        String Rest_Address = String.valueOf(cursor_r.getColumnIndex(DBHelper.Restaurant_ADDRESS));
                        int Rest_Latitude = cursor_r.getColumnIndex(DBHelper.Restaurant_LATITUDE);
                        int Rest_Longitude = cursor_r.getColumnIndex(DBHelper.Restaurant_LONGITUDE);

                        Log.d("mLog","Широта "+ Rest_Latitude + "Долгота " + Rest_Longitude);
                        Log.d("mLog","Взялллллллллллллллллллллллллллллллллллллллл");
                        Log.d("mLog",Rest_id +"айдиииииииииииииииииииииииии");
                        MapObjectCollection pointCollection2 = mapview.getMap().getMapObjects().addCollection();
                        pointCollection2.addTapListener(mapObjectTapListener_res);
                        do {
                            double latitude2 = Double.parseDouble(cursor_r.getString(Rest_Latitude));
                            double longitude2 = Double.parseDouble(cursor_r.getString(Rest_Longitude));
                            Log.d("mLog","Широта "+ latitude2 + "Долгота " + longitude2);
                            Point point = new Point(latitude2, longitude2);



                            PlacemarkMapObject placemarkMapObject = pointCollection2.addPlacemark(point, ImageProvider.fromResource(MainActivity.this,
                                    R.drawable.rest_loct));
                            placemarkMapObject.setUserData(cursor_r.getString(Rest_Name));
                            Log.d("mLog","Метка создалась");
                            Log.d("mLog",Rest_id +"айдиииииииииииииииииииииииии");
                            placemarkMapObject.addTapListener(mapObjectTapListener_res);

                        } while (cursor_r.moveToNext());
                    } else Log.d("mLog","0 rows");

                    butt_counter2 = 0;
                    cursor_r.close();
                }else{
                    mapview.getMap().getMapObjects().clear();
                    L_lmain.removeAllViews();
                    butt_counter2 = 1;
                }
            }
        });
// нажате на кнопку поиска на клавиатуре
        searchEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    const_search_state = 0;
                    submitQuery(searchEdit.getText().toString());
                }
                Log.i(TAG, "lllllllllllllllllllllllllllllllllll");
                return false;
            }
        });
// нажатие на кнопку скрытия поиска
        ic_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftKeyboard();
                searchEdit.setText("");
            }
        });
        // загрузка поисковых данных при старте
        if (const_search_state == 1){
            mapview.getMap().getMapObjects().clear();
        }else{
            Log.i(TAG, "ffffffffffffffffffffffffffffffffffff");
            submitQuery(searchEdit.getText().toString());
            Log.i(TAG, "iiiiiiiiiiiiiiiiiiii");
        }
    }

    private MapObjectTapListener mapObjectTapListener = new MapObjectTapListener() {
        @Override
        public boolean onMapObjectTap(@NonNull MapObject mapObject, @NonNull Point point) {
            String df = (String) mapObject.getUserData();

            Intent intent = new Intent(MainActivity.this, Museum_Point.class);
            intent.putExtra("Name_key", df);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivityForResult(intent, RESULT_CODE_MUSEUM_POINT);

            return true;
        }
    };

    private MapObjectTapListener mapObjectTapListener_res = new MapObjectTapListener() {
        @Override
        public boolean onMapObjectTap(@NonNull MapObject mapObject, @NonNull Point point) {
            String dff = (String) mapObject.getUserData();

            Intent intent = new Intent(MainActivity.this, Restaurant_Point.class);
            intent.putExtra("Name_key_res", dff);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivityForResult(intent, RESULT_CODE_Restaurant_POINT);

            return true;
        }
    };

    // скрытие виртуальной клавиатуры при закрытии поиска
    private void hideSoftKeyboard(){
        //Обращаемся к окну устанавливаем клавиатуру в режим всегда скрыта
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        const_search_state = 1;
    }


//изменение геопозиции
    private void setAnchor() {
        userLocationLayer.setAnchor(
                new PointF((float)(mapview.getWidth() * 0.5), (float)(mapview.getHeight() * 0.5)),
                new PointF((float)(mapview.getWidth() * 0.5), (float)(mapview.getHeight() * 0.83)));

        followUserLocation = false;
    }

    private void noAnchor() {
        userLocationLayer.resetAnchor();
    }
// определение позиции пользователя
    private void cameraUserPosition() {
        if (userLocationLayer.cameraPosition() != null) {

            routeStartLocation = userLocationLayer.cameraPosition().getTarget();
            Log.i(TAG, userLocationLayer + "Местоположение пользователя найденно");
            mapview.getMap().move( new
                            CameraPosition(routeStartLocation, 16f, 0f, 0f),
                    new Animation(Animation.Type.SMOOTH, 1),
                    null);
        } else {
            Toast.makeText(MainActivity.this, "Please Wait...", Toast.LENGTH_SHORT).show();
//            mapview.getMap().move(
//                    new CameraPosition(new Point(59.9386, 30.3141), 12.0f, 0.0f, 0.0f),
//                    new Animation(Animation.Type.SMOOTH, 0),
//                    null);
            Log.i(TAG, userLocationLayer + "Местоположение пользователя нееееее найдено");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapview.onStop();
        MapKitFactory.getInstance().onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapview.onStart();
        MapKitFactory.getInstance().onStart();
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause");

    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume");
        cameraUserPosition();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DBManager dbManager = new DBManager(this);
        dbManager.Delete_Mus();
        dbManager.Delete_Res();
        dbManager.Close_Db();
    }

    // добавление объектов ориентирования
    @Override
    public void onObjectAdded(@NonNull UserLocationView userLocationView) {
        userLocationView.getArrow().setIcon(ImageProvider.fromResource(
                this, R.drawable.arrow));

//        userLocationLayer.setAnchor(
//                new PointF((float)(mapview.getWidth() * 0.5), (float)(mapview.getHeight() * 0.5)),
//                new PointF((float)(mapview.getWidth() * 0.5), (float)(mapview.getHeight() * 0.83)));
        CompositeIcon pinIcon = userLocationView.getPin().useCompositeIcon();

        pinIcon.setIcon(
                "icon",
                ImageProvider.fromResource(this, R.drawable.widget_back),
                new IconStyle().setAnchor(new PointF(0.5f, 1f))
                        .setRotationType(RotationType.ROTATE)
                        .setZIndex(0f)
                        .setScale(1f)
        );

        pinIcon.setIcon(
                "pin",
                ImageProvider.fromResource(this, R.drawable.arrow),
                new IconStyle().setAnchor(new PointF(0.5f, 0.5f))
                        .setRotationType(RotationType.ROTATE)
                        .setZIndex(1f)
                        .setScale(0.5f)
        );

        userLocationView.getAccuracyCircle().setFillColor(Color.BLUE & 0x99ffffff);
    }

    @Override
    public void onObjectRemoved(@NonNull UserLocationView userLocationView) {
        userLocationLayer.resetAnchor();
    }

    @Override
    public void onObjectUpdated(@NonNull UserLocationView userLocationView, @NonNull ObjectEvent objectEvent) {
        setAnchor();
    }

    ////////////////////////////////////////////////////////////////////////////


// поиск геолокации
    @Override
    public void onSearchResponse(@NonNull Response response) {
        Log.i(TAG, "jjjjjjjjjjjjjjjjjjj");
        if (const_search_state == 0) {
            Log.i(TAG, "onSearchResponse: " + searchEdit);
            submitQuery(searchEdit.getText().toString());
            MapObjectCollection mapObjects = mapview.getMap().getMapObjects();
            mapObjects.clear();

            for (GeoObjectCollection.Item searchResult : response.getCollection().getChildren()) {
                Point resultLocation = searchResult.getObj().getGeometry().get(0).getPoint();
                if (resultLocation != null) {
                    mapObjects.addPlacemark(
                            resultLocation,
                            ImageProvider.fromResource(this, R.drawable.loct));
//                    if (searchEdit != null) {
//                        mapView.getMap().move(
//                                new CameraPosition(resultLocation, 14.0f, 0.0f, 0.0f));
//                    }
                }
            }
        }else {
            mapview.getMap().getMapObjects().clear();
        }
    }

    @Override
    public void onSearchError(@NonNull Error error) {
        String errorMessage = "unknown_error";
        if (error instanceof RemoteError) {
            errorMessage = "remote_error";
        } else if (error instanceof NetworkError) {
            errorMessage = "network_error";
        }

        Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    //////////////
    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        openQuitDialog();
    }
    private void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                MainActivity.this);
        quitDialog.setTitle("Exit: Are you sure?");

        quitDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });

        quitDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
            }
        });

        quitDialog.show();
    }

    @Override
    public boolean onObjectTap(@NonNull GeoObjectTapEvent geoObjectTapEvent) {
        Log.i(TAG, "oooooooooooooooooooooo");
        final GeoObjectSelectionMetadata selectionMetadata = geoObjectTapEvent
                .getGeoObject()
                .getMetadataContainer()
                .getItem(GeoObjectSelectionMetadata.class);
        Log.i(TAG, selectionMetadata + "sssssssssssssssss");

        if (selectionMetadata != null) {
            mapview.getMap().selectGeoObject(selectionMetadata.getId(), selectionMetadata.getLayerId());
//            mapView.getMap().getMapObjects().addPlacemark(geoObjectTapEvent.getGeoObject(), ImageProvider.fromResource(MainActivity.this,
//                    R.drawable.loct));
            String t = mapview.getMap().getCameraPosition().toString();
            Log.i(TAG, t+"     oooooooooooooooooooooo");
        }

        return selectionMetadata != null;
    }


    @Override
    public void onMapTap(@NonNull Map map, @NonNull Point point) {
        Log.i(TAG, "bbbbbbbbbbbbbbbbbbbbbbbbbb");
        mapview.getMap().deselectGeoObject();
        double t = point.getLatitude();
        Log.i(TAG, t+"bbbbbbbbbbbbbbbbbbbbbbbbbb");
    }

    @Override
    public void onMapLongTap(@NonNull Map map, @NonNull Point point) {

        cameraUserPosition();
        Log.i(TAG, "Нажжжжжжжжжжжжжжжжжал");
        routeStartLocation = userLocationLayer.cameraPosition().getTarget();
        Double lat_locate = routeStartLocation.getLatitude();
        Double long_locate = routeStartLocation.getLongitude();
        Point Start_Loc = point;
        Point End_Loc = new Point(lat_locate , long_locate);
        drivingRouter = DirectionsFactory.getInstance().createDrivingRouter();

        mapObjects = mapview.getMap().getMapObjects().addCollection();

        submitRequest(Start_Loc, End_Loc);
        But_clear();
    }

    @Override
    public void onDrivingRoutes(@NonNull List<DrivingRoute> routes) {
        for (DrivingRoute route : routes) {
            mapObjects.addPolyline(route.getGeometry());
        }
    }

    @Override
    public void onDrivingRoutesError(@NonNull Error error) {
        String errorMessage = "Network error";
        if (error instanceof RemoteError) {
            errorMessage = "Remote server error";
        } else if (error instanceof NetworkError) {
            errorMessage = "Unknown error";
        }

        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }


    private void submitRequest(Point Start_Locate, Point End_Locate) {
        DrivingOptions drivingOptions = new DrivingOptions();
        VehicleOptions vehicleOptions = new VehicleOptions();
        ArrayList<RequestPoint> requestPoints = new ArrayList<>();
        requestPoints.add(new RequestPoint(
                Start_Locate,
                RequestPointType.WAYPOINT,
                null));
        requestPoints.add(new RequestPoint(
                End_Locate,
                RequestPointType.WAYPOINT,
                null));

        mapObjects.addPlacemark(Start_Locate,
                ImageProvider.fromResource(this, R.drawable.loct));


        drivingSession = drivingRouter.requestRoutes(requestPoints, drivingOptions, vehicleOptions, this);
    }

    public void But_close(){
        LinearLayout.LayoutParams llpar = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        Button button_close = new Button(this);
        Drawable drawable0 = getResources().getDrawable(R.drawable.widget_back);
        button_close.setBackground(drawable0);
        button_close.setText("Close");
        L_lmain.addView(button_close, llpar);

        button_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L_lmain.removeAllViews();
                mapObjects.clear();
                But_clear();
            }
        });

    }

    public void But_clear(){
        LinearLayout.LayoutParams llpar = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        Button button_clear = new Button(this);
        Drawable drawable0 = getResources().getDrawable(R.drawable.widget_back);
//        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) button_clear.getLayoutParams();
//        lp.setMargins(5,5,5,5);
        button_clear.setBackground(drawable0);
        button_clear.setText("Clear");
        L_lmain.addView(button_clear, llpar);

        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L_lmain.removeAllViews();
//                mapObjects.clear();
                mapview.getMap().getMapObjects().clear();

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            switch (requestCode){
                case RESULT_CODE_MUSEUM_POINT:
                    double latitude = data.getDoubleExtra("Mus_point_Lat", 0.00);
                    double longitude = data.getDoubleExtra("Mus_point_Long", 0.00);
                    cameraUserPosition();
                    double lat_locate = routeStartLocation.getLatitude();
                    double long_locate = routeStartLocation.getLongitude();

                    Point st_Point = new Point(latitude, longitude);
                    Point End_Locate = new Point(lat_locate, long_locate);
                    drivingRouter = DirectionsFactory.getInstance().createDrivingRouter();

                    mapObjects = mapview.getMap().getMapObjects().addCollection();
                    submitRequest(st_Point, End_Locate);
                    But_close();
                    break;

                case RESULT_CODE_ROUTE_1:
                    cameraUserPosition();
                    String Name_point_1 = data.getStringExtra("Name_Mus_point_1");
                    String Name_point_2 = data.getStringExtra("Name_Mus_point_2");
                    String Name_point_3 = data.getStringExtra("Name_Mus_point_3");
                    String Name_point_4 = data.getStringExtra("Name_Mus_point_4");
                    String Name_point_5 = data.getStringExtra("Name_Mus_point_5");
                    String Name_point_6 = data.getStringExtra("Name_Mus_point_6");
                    String Name_point_7 = data.getStringExtra("Name_Mus_point_7");
                    String Name_point_8 = data.getStringExtra("Name_Mus_point_8");

//                    double lat_locate2 = routeStartLocation.getLatitude();
//                    double long_locate2 = routeStartLocation.getLongitude();
//
//                    Point End_Locate2 = new Point(lat_locate2, long_locate2);

                    Route_1_Petropavlovka();

                    But_clear();
                    break;

                case RESULT_CODE_Restaurant_POINT:
                    double latitude2 = data.getDoubleExtra("Res_point_Lat", 0.00);
                    double longitude2 = data.getDoubleExtra("Res_point_Long", 0.00);

                    cameraUserPosition();
                    double lat_locate2 = routeStartLocation.getLatitude();
                    double long_locate2 = routeStartLocation.getLongitude();

                    Point st_Point2 = new Point(latitude2, longitude2);
                    Point End_Locate2 = new Point(lat_locate2, long_locate2);
                    drivingRouter = DirectionsFactory.getInstance().createDrivingRouter();

                    mapObjects = mapview.getMap().getMapObjects().addCollection();
                    submitRequest(st_Point2, End_Locate2);
                    But_close();
                    break;

                case RESULT_CODE_ROUTE_2:
                    cameraUserPosition();
                    String Name_point_1_1 = data.getStringExtra("Name_Mus_point_1");
                    String Name_point_2_1 = data.getStringExtra("Name_Mus_point_2");
                    String Name_point_3_1 = data.getStringExtra("Name_Mus_point_3");
                    String Name_point_4_1 = data.getStringExtra("Name_Mus_point_4");
                    Route_2_Nevsky();
                    But_clear();
                    break;
                case RESULT_CODE_ROUTE_3:
                    cameraUserPosition();

                    Route_3_Pushkin();
                    But_clear();
                    break;
            }

        }
    }
////////////////контекстное меню для выбора маршрута
    public void showPopup (View v){
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.inflate(R.menu.main_menu);

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){

                    case R.id.id_route_1:
                        Toast.makeText(MainActivity.this, "The first route is selected", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Roude_1_Petropavlovka.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        intent.putExtra("Name_key", "Route1");
                        startActivityForResult(intent, RESULT_CODE_ROUTE_1);
                        break;
                    case R.id.id_route_2:
                        Toast.makeText(MainActivity.this, "The second route is selected", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(MainActivity.this, Route_2_Nevsky.class);
                        intent2.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        intent2.putExtra("Name_key", "Route2");
                        startActivityForResult(intent2, RESULT_CODE_ROUTE_2);
                        break;
                    case R.id.id_route_3:
                        Toast.makeText(MainActivity.this, "The third route is selected", Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent(MainActivity.this, Route_3_Pushkin.class);
                        intent3.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        intent3.putExtra("Name_key", "Route2");
                        startActivityForResult(intent3, RESULT_CODE_ROUTE_3);
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }

    private void Route_1_Petropavlovka(){

        int Name_Mus_point_5 = 34;
        int Name_Mus_point_6 = 35;
        int Name_Mus_point_8 = 36;
        int Name_Mus_point_7 = 37;
        int Name_Mus_point_3 = 38;
        int Name_Mus_point_2 = 39;
        int Name_Mus_point_1 = 40;
        int Name_Mus_point_4 = 41;

        Log.d("mLog",Name_Mus_point_1+ "Взялллллллллллллллллллллллллллллллллллллллл");

        DBManager dbManager = new DBManager(this);
        dbManager.Open_Db();

        String query = "SELECT " + DBHelper.Mus_ID + ", "
                + DBHelper.Museum_NAME +  ", "
                + DBHelper.Museum_INFO +  ", "
                + DBHelper.Museum_ADDRESS +  ", "
                + DBHelper.Museum_LATITUDE +  ", "
                + DBHelper.Museum_LONGITUDE +  ", "
                + DBHelper.Museum_IMG_SOURCE + " FROM " + DBHelper.TABLE_MUSEUMS + " WHERE " + DBHelper.Mus_ID + " = " + Name_Mus_point_1 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_2 +
                " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_3 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_4 +
                " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_5 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_6 +
                " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_7 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_8;

        Cursor cursor2 = dbManager.db.rawQuery(query, null);

        if (cursor2.moveToFirst()){

            int Mus_id = cursor2.getColumnIndex(DBHelper.Mus_ID);
            int Mus_Name = cursor2.getColumnIndex(DBHelper.Museum_NAME);
            String Museum_Info = String.valueOf(cursor2.getColumnIndex(DBHelper.Museum_INFO));
            String Museum_Address = String.valueOf(cursor2.getColumnIndex(DBHelper.Museum_ADDRESS));
            int Museum_Latitude = cursor2.getColumnIndex(DBHelper.Museum_LATITUDE);
            int Museum_Longitude = cursor2.getColumnIndex(DBHelper.Museum_LONGITUDE);

            Log.d("mLog","Широта "+ Museum_Latitude + "Долгота " + Museum_Longitude);
            Log.d("mLog","Взялллллллллллллллллллллллллллллллллллллллл");
            Log.d("mLog",Mus_id +"айдиииииииииииииииииииииииии");
            MapObjectCollection pointCollection = mapview.getMap().getMapObjects().addCollection();
            pointCollection.addTapListener(mapObjectTapListener);
            do {
                double latitude = Double.parseDouble(cursor2.getString(Museum_Latitude));
                double longitude = Double.parseDouble(cursor2.getString(Museum_Longitude));
                Log.d("mLog","Широта "+ latitude + "Долгота " + longitude);
                Point point = new Point(latitude, longitude);


                PlacemarkMapObject placemarkMapObject = pointCollection.addPlacemark(point, ImageProvider.fromResource(MainActivity.this,
                        R.drawable.loct));
                placemarkMapObject.setUserData(cursor2.getString(Mus_Name));
                Log.d("mLog","Метка создалась");
                Log.d("mLog",Mus_id +"айдиииииииииииииииииииииииии");

            } while (cursor2.moveToNext());
        } else Log.d("mLog","0 rows");

        cursor2.close();

        Point point35 = new Point(59.950238, 30.316374);

        mapview.getMap().move( new
                        CameraPosition(point35, 14f, 0f, 0f),
                new Animation(Animation.Type.SMOOTH, 1),
                null);

//        drivingRouter = DirectionsFactory.getInstance().createDrivingRouter();
//
//        mapObjects = mapview.getMap().getMapObjects().addCollection();
//        submitRequest(point1, End_Locate2);
//        submitRequest(point2, point1);
//        submitRequest(point3, point2);
//        submitRequest(point4, point3);
//        submitRequest(point6, point5);
//        submitRequest(point7, point6);
//        submitRequest(point8, point7);
    }

    private void Route_2_Nevsky(){
        int Name_Mus_point_1 = 100;
        int Name_Mus_point_2 = 101;
        int Name_Mus_point_3 = 78;
        int Name_Mus_point_4 = 77;
        int Name_Mus_point_5 = 76;
        int Name_Mus_point_6 = 69;
        int Name_Mus_point_7 = 73;
        int Name_Mus_point_8 = 68;
        int Name_Mus_point_9 = 72;
        int Name_Mus_point_10 = 67;
        int Name_Mus_point_11 = 9;
        int Name_Mus_point_12 = 13;
        int Name_Mus_point_13 = 6;
        int Name_Mus_point_14 = 14;
        int Name_Mus_point_15 = 15;
        int Name_Mus_point_16 = 8;
        int Name_Mus_point_17 = 26;

        Point point_route1 = null;
        Point point_route2 = null;
        Point point_route3 = null;
        Point point_route4 = null;
        Point point_route5 = null;
        Point point_route6 = null;
        Point point_route7 = null;
        Point point_route8 = null;
        Point point_route9 = null;
        Point point_route10 = null;
        Point point_route11 = null;
        Point point_route12 = null;
        Point point_route13 = null;
        Point point_route14 = null;
        Point point_route15 = null;
        Point point_route16 = null;
        Point point_route17 = null;
        DBManager dbManager = new DBManager(this);
        dbManager.Open_Db();


        String query = "SELECT " + DBHelper.Mus_ID + ", "
                + DBHelper.Museum_NAME +  ", "
                + DBHelper.Museum_INFO +  ", "
                + DBHelper.Museum_ADDRESS +  ", "
                + DBHelper.Museum_LATITUDE +  ", "
                + DBHelper.Museum_LONGITUDE +  ", "
                + DBHelper.Museum_IMG_SOURCE + " FROM " + DBHelper.TABLE_MUSEUMS + " WHERE " + DBHelper.Mus_ID + " = " + Name_Mus_point_1 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_2 +
                " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_3 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_4 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_5 +
                " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_6 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_7 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_8 +
                " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_9 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_10 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_11 +
                " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_12 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_13 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_14 +
                " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_15 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_16 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_17;

        Cursor cursor3 = dbManager.db.rawQuery(query, null);

        if (cursor3.moveToFirst()){

            int Mus_id = cursor3.getColumnIndex(DBHelper.Mus_ID);
            int Mus_Name = cursor3.getColumnIndex(DBHelper.Museum_NAME);
            String Museum_Info = String.valueOf(cursor3.getColumnIndex(DBHelper.Museum_INFO));
            String Museum_Address = String.valueOf(cursor3.getColumnIndex(DBHelper.Museum_ADDRESS));
            int Museum_Latitude = cursor3.getColumnIndex(DBHelper.Museum_LATITUDE);
            int Museum_Longitude = cursor3.getColumnIndex(DBHelper.Museum_LONGITUDE);
            int Img_Source = cursor3.getColumnIndex(DBHelper.Museum_IMG_SOURCE);

            Log.d("mLog","Широта "+ Museum_Latitude + "Долгота " + Museum_Longitude);
            Log.d("mLog","Взялллллллллллллллллллллллллллллллллллллллл");
            Log.d("mLog",Mus_id +"айдиииииииииииииииииииииииии");
            MapObjectCollection pointCollection = mapview.getMap().getMapObjects().addCollection();
            pointCollection.addTapListener(mapObjectTapListener);
            do {
                int Id_counter = cursor3.getInt(Mus_id);
                switch (Id_counter){

                    case 100:
                        double latitude = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude + "Долгота " + longitude);
                        Point point = new Point(latitude, longitude);

                        PlacemarkMapObject placemarkMapObject = pointCollection.addPlacemark(point, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject.setUserData(cursor3.getString(Mus_Name));
                        Log.d("mLog","Метка создалась");
                        Log.d("mLog",Mus_id +"айдиииииииииииииииииииииииии");
                        point_route1 = point;
                        break;
                    case 101:
                        double latitude2 = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude2 = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude2 + "Долгота " + longitude2);
                        Point point2 = new Point(latitude2, longitude2);

                        PlacemarkMapObject placemarkMapObject2 = pointCollection.addPlacemark(point2, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject2.setUserData(cursor3.getString(Mus_Name));
                        point_route2 = point2;
                        break;
                    case 78:
                        double latitude3 = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude3 = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude3 + "Долгота " + longitude3);
                        Point point3 = new Point(latitude3, longitude3);


                        PlacemarkMapObject placemarkMapObject3 = pointCollection.addPlacemark(point3, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject3.setUserData(cursor3.getString(Mus_Name));
                        point_route3 = point3;
                        break;
                    case 77:
                        double latitude4 = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude4 = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude4 + "Долгота " + longitude4);
                        Point point4 = new Point(latitude4, longitude4);

                        PlacemarkMapObject placemarkMapObject4 = pointCollection.addPlacemark(point4, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject4.setUserData(cursor3.getString(Mus_Name));
                        point_route4 = point4;
                        break;
                    case 76:
                        double latitude5 = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude5 = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude5 + "Долгота " + longitude5);
                        Point point5 = new Point(latitude5, longitude5);

                        PlacemarkMapObject placemarkMapObject5 = pointCollection.addPlacemark(point5, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject5.setUserData(cursor3.getString(Mus_Name));
                        point_route5 = point5;
                        break;
                    case 69:
                        // 6
                        double latitude6 = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude6 = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude6 + "Долгота " + longitude6);
                        Point point6 = new Point(latitude6, longitude6);

                        PlacemarkMapObject placemarkMapObject6 = pointCollection.addPlacemark(point6, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject6.setUserData(cursor3.getString(Mus_Name));
                        point_route6 = point6;
                        break;
                    case 73:
                        double latitude7 = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude7 = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude7 + "Долгота " + longitude7);
                        Point point7 = new Point(latitude7, longitude7);

                        PlacemarkMapObject placemarkMapObject7 = pointCollection.addPlacemark(point7, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject7.setUserData(cursor3.getString(Mus_Name));
                        point_route7 = point7;
                        break;
                    case 68:
                        double latitude8 = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude8 = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude8 + "Долгота " + longitude8);
                        Point point8 = new Point(latitude8, longitude8);

                        PlacemarkMapObject placemarkMapObject8 = pointCollection.addPlacemark(point8, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject8.setUserData(cursor3.getString(Mus_Name));
                        point_route8 = point8;
                        break;
                    case 72:
                        double latitude9 = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude9 = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude9 + "Долгота " + longitude9);
                        Point point9 = new Point(latitude9, longitude9);

                        PlacemarkMapObject placemarkMapObject9 = pointCollection.addPlacemark(point9, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject9.setUserData(cursor3.getString(Mus_Name));
                        point_route9 = point9;
                        break;
                    case 67:
                        double latitude10 = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude10 = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude10 + "Долгота " + longitude10);
                        Point point10 = new Point(latitude10, longitude10);

                        PlacemarkMapObject placemarkMapObject10 = pointCollection.addPlacemark(point10, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject10.setUserData(cursor3.getString(Mus_Name));
                        point_route10 = point10;
                        break;
                    case 9:
                        double latitude11 = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude11 = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude11 + "Долгота " + longitude11);
                        Point point11 = new Point(latitude11, longitude11);

                        PlacemarkMapObject placemarkMapObject11 = pointCollection.addPlacemark(point11, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject11.setUserData(cursor3.getString(Mus_Name));
                        point_route11 = point11;
                        break;
                    case 13:
                        double latitude12 = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude12 = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude12 + "Долгота " + longitude12);
                        Point point12 = new Point(latitude12, longitude12);

                        PlacemarkMapObject placemarkMapObject12 = pointCollection.addPlacemark(point12, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject12.setUserData(cursor3.getString(Mus_Name));
                        point_route12 = point12;
                        break;
                    case 6:
                        double latitude13 = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude13 = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude13 + "Долгота " + longitude13);
                        Point point13 = new Point(latitude13, longitude13);

                        PlacemarkMapObject placemarkMapObject13 = pointCollection.addPlacemark(point13, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject13.setUserData(cursor3.getString(Mus_Name));
                        point_route13 = point13;
                        break;
                    case 14:
                        double latitude14 = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude14 = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude14 + "Долгота " + longitude14);
                        Point point14 = new Point(latitude14, longitude14);

                        PlacemarkMapObject placemarkMapObject14 = pointCollection.addPlacemark(point14, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject14.setUserData(cursor3.getString(Mus_Name));
                        point_route14 = point14;
                        break;
                    case 15:
                        double latitude15 = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude15 = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude15 + "Долгота " + longitude15);
                        Point point15 = new Point(latitude15, longitude15);

                        PlacemarkMapObject placemarkMapObject15 = pointCollection.addPlacemark(point15, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject15.setUserData(cursor3.getString(Mus_Name));
                        point_route15 = point15;
                        break;
                    case 8:
                        double latitude16 = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude16 = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude16 + "Долгота " + longitude16);
                        Point point16 = new Point(latitude16, longitude16);

                        PlacemarkMapObject placemarkMapObject16 = pointCollection.addPlacemark(point16, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject16.setUserData(cursor3.getString(Mus_Name));
                        point_route16 = point16;
                        break;
                    case 26:
                        double latitude17 = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude17 = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude17 + "Долгота " + longitude17);
                        Point point17 = new Point(latitude17, longitude17);

                        PlacemarkMapObject placemarkMapObject17 = pointCollection.addPlacemark(point17, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject17.setUserData(cursor3.getString(Mus_Name));
                        point_route17 = point17;
                        break;


                }

            } while (cursor3.moveToNext());
        } else Log.d("mLog","0 rows");

        cursor3.close();
//        drivingRouter = DirectionsFactory.getInstance().createDrivingRouter();
//
//        mapObjects = mapview.getMap().getMapObjects().addCollection();
//        submitRequest(point_route2, point_route1);
//        submitRequest(point_route3, point_route2);
//        submitRequest(point_route4, point_route3);
//        submitRequest(point_route5, point_route4);
//        submitRequest(point_route6, point_route5);
//        submitRequest(point_route7, point_route6);
//        submitRequest(point_route8, point_route7);
//        submitRequest(point_route9, point_route8);
//        submitRequest(point_route10, point_route9);
//        submitRequest(point_route11, point_route10);
//        submitRequest(point_route12, point_route11);
//        submitRequest(point_route13, point_route12);
//        submitRequest(point_route14, point_route13);
//        submitRequest(point_route15, point_route14);
//        submitRequest(point_route16, point_route15);
//        submitRequest(point_route17, point_route16);

        mapview.getMap().move( new
                        CameraPosition(point_route1, 16f, 0f, 0f),
                new Animation(Animation.Type.SMOOTH, 1),
                null);
    }

    public void Route_3_Pushkin(){

        int Name_Mus_point_1 = 144;
        int Name_Mus_point_2 = 2;
        int Name_Mus_point_3 = 1;
        int Name_Mus_point_4 = 141;
        int Name_Mus_point_5 = 137;
        int Name_Mus_point_6 = 143;
        int Name_Mus_point_7 = 138;
        int Name_Mus_point_8 = 142;
        int Name_Mus_point_9 = 139;
        int Name_Mus_point_10 = 140;

        Point point_route1 = null;
        Point point_route2 = null;
        Point point_route3 = null;
        Point point_route4 = null;
        Point point_route5 = null;
        Point point_route6 = null;
        Point point_route7 = null;
        Point point_route8 = null;
        Point point_route9 = null;
        Point point_route10 = null;

        DBManager dbManager = new DBManager(this);
        dbManager.Open_Db();


        String query = "SELECT " + DBHelper.Mus_ID + ", "
                + DBHelper.Museum_NAME +  ", "
                + DBHelper.Museum_INFO +  ", "
                + DBHelper.Museum_ADDRESS +  ", "
                + DBHelper.Museum_LATITUDE +  ", "
                + DBHelper.Museum_LONGITUDE +  ", "
                + DBHelper.Museum_IMG_SOURCE + " FROM " + DBHelper.TABLE_MUSEUMS + " WHERE " + DBHelper.Mus_ID + " = " + Name_Mus_point_1 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_2 +
                " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_3 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_4 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_5 +
                " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_6 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_7 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_8 +
                " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_9 + " OR " + DBHelper.Mus_ID + " = " + Name_Mus_point_10;

        Cursor cursor3 = dbManager.db.rawQuery(query, null);

        if (cursor3.moveToFirst()){

            int Mus_id = cursor3.getColumnIndex(DBHelper.Mus_ID);
            int Mus_Name = cursor3.getColumnIndex(DBHelper.Museum_NAME);
            String Museum_Info = String.valueOf(cursor3.getColumnIndex(DBHelper.Museum_INFO));
            String Museum_Address = String.valueOf(cursor3.getColumnIndex(DBHelper.Museum_ADDRESS));
            int Museum_Latitude = cursor3.getColumnIndex(DBHelper.Museum_LATITUDE);
            int Museum_Longitude = cursor3.getColumnIndex(DBHelper.Museum_LONGITUDE);
            int Img_Source = cursor3.getColumnIndex(DBHelper.Museum_IMG_SOURCE);

            Log.d("mLog","Широта "+ Museum_Latitude + "Долгота " + Museum_Longitude);
            Log.d("mLog","Взялллллллллллллллллллллллллллллллллллллллл");
            Log.d("mLog",Mus_id +"айдиииииииииииииииииииииииии");
            MapObjectCollection pointCollection = mapview.getMap().getMapObjects().addCollection();
            pointCollection.addTapListener(mapObjectTapListener);
            do {
                int Id_counter = cursor3.getInt(Mus_id);
                switch (Id_counter){

                    case 144:
                        double latitude = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude + "Долгота " + longitude);
                        Point point = new Point(latitude, longitude);

                        PlacemarkMapObject placemarkMapObject = pointCollection.addPlacemark(point, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject.setUserData(cursor3.getString(Mus_Name));
                        Log.d("mLog","Метка создалась");
                        Log.d("mLog",Mus_id +"айдиииииииииииииииииииииииии");
                        point_route1 = point;
                        break;
                    case 2:
                        double latitude2 = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude2 = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude2 + "Долгота " + longitude2);
                        Point point2 = new Point(latitude2, longitude2);

                        PlacemarkMapObject placemarkMapObject2 = pointCollection.addPlacemark(point2, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject2.setUserData(cursor3.getString(Mus_Name));
                        point_route2 = point2;
                        break;
                    case 1:
                        double latitude3 = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude3 = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude3 + "Долгота " + longitude3);
                        Point point3 = new Point(latitude3, longitude3);


                        PlacemarkMapObject placemarkMapObject3 = pointCollection.addPlacemark(point3, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject3.setUserData(cursor3.getString(Mus_Name));
                        point_route3 = point3;
                        break;
                    case 141:
                        double latitude4 = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude4 = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude4 + "Долгота " + longitude4);
                        Point point4 = new Point(latitude4, longitude4);

                        PlacemarkMapObject placemarkMapObject4 = pointCollection.addPlacemark(point4, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject4.setUserData(cursor3.getString(Mus_Name));
                        point_route4 = point4;
                        break;
                    case 137:
                        double latitude5 = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude5 = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude5 + "Долгота " + longitude5);
                        Point point5 = new Point(latitude5, longitude5);

                        PlacemarkMapObject placemarkMapObject5 = pointCollection.addPlacemark(point5, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject5.setUserData(cursor3.getString(Mus_Name));
                        point_route5 = point5;
                        break;
                    case 143:
                        // 6
                        double latitude6 = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude6 = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude6 + "Долгота " + longitude6);
                        Point point6 = new Point(latitude6, longitude6);

                        PlacemarkMapObject placemarkMapObject6 = pointCollection.addPlacemark(point6, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject6.setUserData(cursor3.getString(Mus_Name));
                        point_route6 = point6;
                        break;
                    case 138:
                        double latitude7 = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude7 = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude7 + "Долгота " + longitude7);
                        Point point7 = new Point(latitude7, longitude7);

                        PlacemarkMapObject placemarkMapObject7 = pointCollection.addPlacemark(point7, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject7.setUserData(cursor3.getString(Mus_Name));
                        point_route7 = point7;
                        break;
                    case 142:
                        double latitude8 = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude8 = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude8 + "Долгота " + longitude8);
                        Point point8 = new Point(latitude8, longitude8);

                        PlacemarkMapObject placemarkMapObject8 = pointCollection.addPlacemark(point8, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject8.setUserData(cursor3.getString(Mus_Name));
                        point_route8 = point8;
                        break;
                    case 139:
                        double latitude9 = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude9 = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude9 + "Долгота " + longitude9);
                        Point point9 = new Point(latitude9, longitude9);

                        PlacemarkMapObject placemarkMapObject9 = pointCollection.addPlacemark(point9, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject9.setUserData(cursor3.getString(Mus_Name));
                        point_route9 = point9;
                        break;
                    case 140:
                        double latitude10 = Double.parseDouble(cursor3.getString(Museum_Latitude));
                        double longitude10 = Double.parseDouble(cursor3.getString(Museum_Longitude));
                        Log.d("mLog","Широта "+ latitude10 + "Долгота " + longitude10);
                        Point point10 = new Point(latitude10, longitude10);

                        PlacemarkMapObject placemarkMapObject10 = pointCollection.addPlacemark(point10, ImageProvider.fromResource(MainActivity.this,
                                R.drawable.loct));
                        placemarkMapObject10.setUserData(cursor3.getString(Mus_Name));
                        point_route10 = point10;
                        break;

                }

            } while (cursor3.moveToNext());
        } else Log.d("mLog","0 rows");

        cursor3.close();

        mapview.getMap().move( new
                        CameraPosition(point_route1, 16f, 0f, 0f),
                new Animation(Animation.Type.SMOOTH, 1),
                null);


    }
}


