package com.example.mymapkit;

import static android.content.ContentValues.TAG;

import android.graphics.Color;
import android.graphics.PointF;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKit;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.layers.ObjectEvent;
import com.yandex.mapkit.location.Location;
import com.yandex.mapkit.location.LocationListener;
import com.yandex.mapkit.location.LocationStatus;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.map.CompositeIcon;
import com.yandex.mapkit.map.IconStyle;
import com.yandex.mapkit.map.RotationType;
import com.yandex.mapkit.mapview.MapView;
import com.yandex.mapkit.user_location.UserLocationLayer;
import com.yandex.mapkit.user_location.UserLocationObjectListener;
import com.yandex.mapkit.user_location.UserLocationView;
import com.yandex.runtime.image.ImageProvider;

public class BB {
//    package com.example.mymapkit;
//
//import static android.content.ContentValues.TAG;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.graphics.Color;
//import android.graphics.PointF;
//import android.location.LocationManager;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.ImageView;
//
//import com.yandex.mapkit.Animation;
//import com.yandex.mapkit.MapKit;
//import com.yandex.mapkit.MapKitFactory;
//import com.yandex.mapkit.geometry.Point;
//import com.yandex.mapkit.layers.ObjectEvent;
//import com.yandex.mapkit.location.Location;
//import com.yandex.mapkit.location.LocationListener;
//import com.yandex.mapkit.location.LocationStatus;
//import com.yandex.mapkit.map.CameraPosition;
//import com.yandex.mapkit.map.CompositeIcon;
//import com.yandex.mapkit.map.IconStyle;
//import com.yandex.mapkit.map.RotationType;
//import com.yandex.mapkit.mapview.MapView;
//import com.yandex.mapkit.user_location.UserLocationLayer;
//import com.yandex.mapkit.user_location.UserLocationObjectListener;
//import com.yandex.mapkit.user_location.UserLocationView;
//import com.yandex.runtime.image.ImageProvider;
//
//    public class MainActivity extends AppCompatActivity implements UserLocationObjectListener {
//
//        //Создаем обьект карты
//        private MapView mapview;
//        // Создаем локацию для пользователя
//        private UserLocationLayer userLocationLayer;
//
//        private ImageView mGps;
//
//        private LocationManager locationManager;
//        private LocationListener myLocationListener;
//        private Point myLocation;
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//
//            super.onCreate(savedInstanceState);
//            //ключ апи
//            MapKitFactory.setApiKey("8c2094f3-0cf6-42e5-97a8-2711ec731846");
//
//            //инициализируем класс
//            MapKitFactory.initialize(this);
//
//            // устанавливаем разметку
//            setContentView(R.layout.activity_main);
//            mapview = (MapView)findViewById(R.id.mapview);
//
//            mGps = (ImageView)findViewById(R.id.id_gps);
//            // разрешение на поворот камеры
//            mapview.getMap().setRotateGesturesEnabled(true);
//
//            mapview.getMap().move(
//                    new CameraPosition(new Point(59.9386, 30.3141), 12.0f, 0.0f, 0.0f),
//                    new Animation(Animation.Type.SMOOTH, 0),
//                    null);
//
//            MapKit mapKit = MapKitFactory.getInstance();
//            userLocationLayer = mapKit.createUserLocationLayer(mapview.getMapWindow());
//            userLocationLayer.setVisible(true);
//            userLocationLayer.setHeadingEnabled(true);
//
//            userLocationLayer.setObjectListener((UserLocationObjectListener) com.example.mymapkit.MainActivity.this);
//
//            locationManager = (LocationManager) MapKitFactory.getInstance().createLocationManager();
//            myLocationListener = new LocationListener() {
//                @Override
//                public void onLocationUpdated(@NonNull Location location) {
//                    if (myLocation == null) {
//                        moveCamera(location.getPosition(), 18);
//                    }
//                    myLocation = location.getPosition(); //this user point
//                    Log.i(TAG, "my location - " + myLocation.getLatitude() + "," + myLocation.getLongitude());
//
//                }
//
//                @Override
//                public void onLocationStatusUpdated(@NonNull LocationStatus locationStatus) {
//                    if (locationStatus == LocationStatus.NOT_AVAILABLE) {
//                        Log.i(TAG, " Не удалось определить локацию");
//                    }
//                }
//            };
//
//            mGps.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (myLocation == null) {
//                        Log.i(TAG, " Не удалось определить локацию");
//                        return;
//                    }
//
//                    moveCamera(myLocation, 18);
//                }
//            });
//
//        }
//        private void moveCamera(Point point, float zoom) {
//            mapview.getMap().move(
//                    new CameraPosition(point, zoom, 0.0f, 0.0f),
//                    new Animation(Animation.Type.SMOOTH, 1),
//                    null);
//        }
//
//
//        @Override
//        protected void onStop() {
//            super.onStop();
//            mapview.onStop();
//            MapKitFactory.getInstance().onStop();
//        }
//
//        @Override
//        protected void onStart() {
//            super.onStart();
//            mapview.onStart();
//            MapKitFactory.getInstance().onStart();
//        }
//
//
//        @Override
//        public void onObjectAdded(@NonNull UserLocationView userLocationView) {
//            userLocationLayer.setAnchor(
//                    new PointF((float)(mapview.getWidth() * 0.5), (float)(mapview.getHeight() * 0.5)),
//                    new PointF((float)(mapview.getWidth() * 0.5), (float)(mapview.getHeight() * 0.83)));
//
//
//            userLocationView.getArrow().setIcon(ImageProvider.fromResource(
//                    this, R.drawable.user_loc));
//
//            CompositeIcon pinIcon = userLocationView.getPin().useCompositeIcon();
//
////        pinIcon.setIcon(
////                "icon",
////                ImageProvider.fromResource(this, R.drawable.icon),
////                new IconStyle().setAnchor(new PointF(0f, 0f))
////                        .setRotationType(RotationType.ROTATE)
////                        .setZIndex(0f)
////                        .setScale(1f)
////        );
//
//            pinIcon.setIcon(
//                    "pin",
//                    ImageProvider.fromResource(this, R.drawable.search_marker),
//                    new IconStyle().setAnchor(new PointF(0.5f, 0.5f))
//                            .setRotationType(RotationType.ROTATE)
//                            .setZIndex(1f)
//                            .setScale(0.5f)
//            );
//
//            userLocationView.getAccuracyCircle().setFillColor(Color.BLUE & 0x99ffffff);
//        }
//
//        @Override
//        public void onObjectRemoved(@NonNull UserLocationView userLocationView) {
//            userLocationLayer.resetAnchor();
//        }
//
//        @Override
//        public void onObjectUpdated(@NonNull UserLocationView userLocationView, @NonNull ObjectEvent objectEvent) {
//
//        }
//    }


}
