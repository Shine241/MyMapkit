package com.example.mymapkit.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private Context context;
    private DBHelper dbHelper;
    public SQLiteDatabase db;

    public DBManager(Context context) {
        this.context = context;
// создаем базу данных и структуры таблиц
        dbHelper = new DBHelper(context);
    }

    public void Open_Db (){
        // для открытия бд
        db = dbHelper.getWritableDatabase();

    }

    public void Close_Db(){

        dbHelper.close();
    }

    public void Insert_To_RESTAURANTS_BARS(String Restaurant_Name, String Restaurant_Info, String Restaurant_Address,
                                           String Restaurant_Latitude, String Restaurant_Longitude, String Restaurant_Img_source){
        ContentValues cv_r = new ContentValues();
        cv_r.put(DBHelper.Restaurant_NAME, Restaurant_Name);
        cv_r.put(DBHelper.Restaurant_INFO, Restaurant_Info);
        cv_r.put(DBHelper.Restaurant_ADDRESS, Restaurant_Address);
        cv_r.put(DBHelper.Restaurant_LATITUDE, Restaurant_Latitude);
        cv_r.put(DBHelper.Restaurant_LONGITUDE, Restaurant_Longitude);
        cv_r.put(DBHelper.Restaurant_IMG_SOURCE, Restaurant_Img_source);
        db.insert(DBHelper.TABLE_RESTAURANTS_BARS, null, cv_r);
    }
    public void Insert_Res(){
        db.beginTransaction();
        try {
            Insert_To_RESTAURANTS_BARS("Entree", "Entree Restaurant is a great place for leisurely lunches and dinners. Cozy atmosphere, excellent cuisine, but the main thing of course is desserts. Eclairs and cheesecake are the best in town.",
                    "St. Petersburg, Griboyedov Canal Embankment 125","59.922556","30.303152","r1");

            Insert_To_RESTAURANTS_BARS("Счастье", "Nice restaurant in the city center. Great place for a pleasant evening, subdued light, cozy tables, friendly atmosphere, great location, nice interior.",
                    "St. Petersburg, Rubinshteina street 15/17","59.929086","30.343878","r2");

            Insert_To_RESTAURANTS_BARS("Счастье", "Nice cozy restaurant in the city center. Great place for a pleasant evening, subdued light, cozy tables, friendly atmosphere, great location, nice interior. The best view is not St. Isaac's Cathedral.",
                    "St. Petersburg, Malaya Morskaya street, 24","59.933996","30.308805","r3");

            Insert_To_RESTAURANTS_BARS("Stereo Pizza Napoletana", "High quality Italian cuisine. Pasta pizza salads are all delicious and identical to made in Italy. A wide selection of beers from their own brewery. Friendly staff. On Friday - Sunday evenings you need to book a table. There may not be a place.",
                    "St. Petersburg, Zhukovsky street, 10","59.936088","30.352674","r4");

            Insert_To_RESTAURANTS_BARS("Leth", "The peculiarity of this place is the unusual serving of dishes and the author's menu. The restaurant is very pleasant, the prices are quite democratic. Located 5 minutes from the Zvenigorodskaya metro station.",
                    "St. Petersburg, Fontanka river embankment, 82","59.926522","30.331985","r5");

            Insert_To_RESTAURANTS_BARS("Alta Marea", "Restaurant with an interesting interior. In such an atmosphere it is pleasant to sit, relax, drink a glass of wine and chat sincerely. Closed panoramic heated gazebos on the roof.",
                    "St. Petersburg, Primorsky prospect, 72 (\"Piterland\", 4th floor)","59.980438","30.211211","r6");

            Insert_To_RESTAURANTS_BARS("Aikiterrasa", "Restaurant with a beautiful view and location. Delicious coffee and good food.",
                    "St. Petersburg, Aptekarskaya embankment 18","59.978227","30.316470","r7");

            Insert_To_RESTAURANTS_BARS("Art-Caviar", "Interesting restaurant with author's cuisine. The main feature of the restaurant is black caviar. Lots of varieties and surprisingly low price. A whole series of dishes with the inclusion of black caviar.",
                    "St. Petersburg, Bolshaya Konyushennaya street 10","59.937630","30.323360","r8");

            Insert_To_RESTAURANTS_BARS("Пышечка", "Great place, delicious donuts, great interior. Coffee is very suitable for donuts, there are several types and, by the way, of very good quality. And for kids or those who don't like coffee, plenty of drinks.",
                    "St. Petersburg, Griboyedov Canal Embankment 56/58","59.926146","30.315208 ","r9");

            Insert_To_RESTAURANTS_BARS("Opetit", "A cozy cafe in the space of the French Institute. All products are ready-made - sandwiches, pastries and desserts. Large selection of coffee and tea. Croissants and sandwiches are great!",
                    "St. Petersburg, Nevsky prospect 12","59.936858","30.315767","r10");

            Insert_To_RESTAURANTS_BARS("ТЧК", "Very nice place. Go through the archway and find a cozy patio with a coffee shop TCHK. This is the place to visit if you like coffee and Peter.",
                    "St. Petersburg, Kamennoostrovsky prospect 18/11","59.959200","30.316412","r11");

            Insert_To_RESTAURANTS_BARS("Chocolate Bar Secret Garden", "A very harmonious cafe with pleasant music and a lively atmosphere. Delicious cuisine with a taste of sweetness and airiness.",
                    "St. Petersburg, Kamennoostrovsky prospect 42","59.966792","30.309607","r12");

            Insert_To_RESTAURANTS_BARS("Chloe Cafe", "The decor is girlishly gentle: there are small marble tables, plush furniture and a wall decorated with a thousand roses. From drinks - coffee with regular and colored milk and lemonades with berries and flowers. From food - smoothie bowls, avocado toast and a huge selection of desserts.",
                    "St. Petersburg, Vasilyevsky Island, Maly avenue 9","9.947961","30.277100","r13");

            Insert_To_RESTAURANTS_BARS("Тепло ", "This is already a classic and iconic place for St. Petersburg, where a very large number of people have visited. And the summer terrace in the very center of the city is a separate magnet in good weather.",
                    "St. Petersburg, Bolshaya Morskaya street 45","59.932184","30.305392","r14");

            Insert_To_RESTAURANTS_BARS("Кафе танцующих огней", "The dance floor is a good club for young people. Alcohol in a reasonable price range, a very pleasant subway atmosphere, there is a backyard where you can go out. Musical themes differ from day to day. There are many places where you can sit down.",
                    "St. Petersburg, Konyushennaya Square, 2, courtyard of the bar \"Dance floor\"","59.939098","30.325832","r16");

            Insert_To_RESTAURANTS_BARS("Algorithm Coffee", "Berlin-inspired specialty coffee shop. Nice authentic St. Petersburg place, there are delicious vegan desserts.",
                    "St. Petersburg, Kazanskaya street 26/27","59.930513","30.317415","r17");

            Insert_To_RESTAURANTS_BARS("Co-op Garage", "Great bar with an impressive bar and delicious food. The pizza is especially good.",
                    "St. Petersburg, Gorokhovaya street 47","59.927040","30.322762","r18");

            Insert_To_RESTAURANTS_BARS("Branch garage", "Great place where you are always welcome. A wide range of author's cocktails for every taste, a well-thought-out menu, large and tasty portions. Burrito is especially good.",
                    "St. Petersburg, Pechatnika Grigoriev street, 12","59.919002","30.351275","r19");

            Insert_To_RESTAURANTS_BARS("R14", "A new understanding of classical Italy from Aram Mnatsakanov. Pizza in a real wood fired oven, great selection of pasta and meats. Great desserts.",
                    "St. Petersburg, Academician Pavlova street, 5","59.977651","30.318614","r20");

            Insert_To_RESTAURANTS_BARS("Birch", "This is a special place not only because of the interesting and unusual cuisine (the menu is small, but refined and even spicy), but also because the staff literally creates joy for the guests.",
                    "Адрес улица Кирочная д.3","59.943922","30.350817","r21");

            Insert_To_RESTAURANTS_BARS("Adept Coffee To Go", "Delicious coffee, high quality products, expensive high-quality interior, a cool author's menu for those who do not like boring classics (which is worth only raff with red pepper).",
                    "St. Petersburg, Bolshaya Konyushennaya street, 9","59.939777","30.323759","r22");

            Insert_To_RESTAURANTS_BARS("Арт кафе Чердак художника", "Very atmospheric place with amazing views. The restaurant is combined with galleries - exhibits can be purchased. The main dish in the restaurant is fondue, quite tasty and non-standard.",
                    "St. Petersburg, Lomonosov street 1/28","59.932272","30.326968","r23");

            Insert_To_RESTAURANTS_BARS("Сад", "Very cozy, atmospheric place. Beautiful English porcelain dishes, a real fireplace, a stylish Christmas tree, live plants, good lighting and many more little things that are responsible for the exemplary surroundings of the establishment.",
                    "St. Petersburg, Bolshaya Zelenina street 23A","59.963086","30.289147","r25");

            Insert_To_RESTAURANTS_BARS("Bellevue", "Species veranda, one of the best in St. Petersburg. Orange wine from the coast of Crimea is very worthy at 850 rubles per glass. Trained staff. Expensive and pretentious place. For a date or a business dinner - the best place.",
                    "St. Petersburg, embankment of the river Moika 22","59.939548","30.319839","r26");

            Insert_To_RESTAURANTS_BARS("Сivil Coffee Bar", "Cozy cafe, convenient location, delicious food and reasonable prices. Polite staff, music is not loud, it's convenient to come and work with a laptop.",
                    "St. Petersburg, Bolshoi prospect of the Petrograd side, 71","59.964569","30.310498","r27");

            Insert_To_RESTAURANTS_BARS("COFFEE ROOM Street", "A wonderful place with a soul that has been invested here literally in all corners: from atmospheric music to really delicious dishes.",
                    "St. Petersburg, Gorokhovaya street, 11","59.934602","30.312667","r28");

            Insert_To_RESTAURANTS_BARS("Cookies Cafe", "Atmospheric interestingly decorated cozy place with wonderful cocoa and healthy delicious desserts without sugar.",
                    "St. Petersburg, Mokhovaya street 14","59.944413","30.345427","r29");

            Insert_To_RESTAURANTS_BARS("Hamlet+Jacks", "Stylish gourmet restaurant. The restaurant specializes in a new interpretation of Russian cuisine and supports local producers and farmers.",
                    "St. Petersburg, Volynsky lane, 2","59.938372","30.321202","r30");

            Insert_To_RESTAURANTS_BARS("Italy", "Very tasty pizza and pasta, nice cozy atmosphere, polite staff.",
                    "St. Petersburg, Bolshoi Prospekt of the Petrograd side, 58","59.961026","30.303277","r31");

            Insert_To_RESTAURANTS_BARS("Я люблю... \"LA PANORAMA\"", "Beautiful panoramic view of the city center, delicious food! Great place to spend time in a great atmosphere!",
                    "St. Petersburg, 26th line of Vasilyevsky Island, 15k2","59.933189","30.256945","r32");

            Insert_To_RESTAURANTS_BARS("Бизе", "Confectionery Bizet is LUXURY quality. No holiday is complete without their pastries or cake. Always friendly, always attentive and always delicious.",
                    "St. Petersburg, Zhukovsky street, 41 ","59.935776","30.357531","r33");

            Insert_To_RESTAURANTS_BARS("Diskette Lounge", "Friendly staff, an impressive list of author's cocktails, the general atmosphere of the establishment in the vaporwave style (music in the hall plus well-placed lighting), as well as excellent hookahs.",
                    "St. Petersburg, Apraksin lane, 2","59.929233","30.324710","r35");

            Insert_To_RESTAURANTS_BARS("NEVESOMOST", "Panoramic restaurant. It is nice to have dinner here, to celebrate some significant event. There is a music program. The kitchen is truly original. Exquisite taste of dishes, impeccable service. The views from the window are amazing, as if you are floating above our beautiful city.",
                    "St. Petersburg, Bolshoi Prospekt of the Petrograd side, 37","59.960060","30.303149","r36");

            Insert_To_RESTAURANTS_BARS("Мечтатели", "A great place for a delicious and leisurely breakfast a stone's throw from the Anichkov Bridge.",
                    "St. Petersburg, embankment of the Fontanka River, 11","59.936838","30.342903","r37");

            Insert_To_RESTAURANTS_BARS("Subzero", "Perhaps one of the most delicious and best places with rolls in St. Petersburg. The kitchen is excellent, there are always a lot of visitors, it is clean, but the institution is more for noisy large companies than to sit quietly and talk.",
                    "St. Petersburg, Rubinshteina street, 38","59.927168","30.343162","r38");

            Insert_To_RESTAURANTS_BARS("Duo Asia", "Great place for dinner, tasty, delicious, staff polite, attentive, helpful. Open kitchen - it is interesting to watch how chefs create masterpieces. Desserts at the highest - the perfect end to dinner.",
                    "St. Petersburg, Rubinshteina street, 20","59.930081","30.344897","r39");

            Insert_To_RESTAURANTS_BARS("Barashki", "A fairly large restaurant on the 5th floor of the Peak Shopping Center, cozy, with a good panoramic view of Sennaya Square.",
                    "St. Petersburg, Efimova street, 2","59.926479","30.320603","r40");

            Insert_To_RESTAURANTS_BARS("Le Courage", "The interior is beautiful, the place is very atmospheric. You can easily walk into this in any evening and elegant dress and look appropriate.",
                    "St. Petersburg, Baskov lane, 2","59.939728","30.352764","r41");

            Insert_To_RESTAURANTS_BARS("Hard rock cafe", "The place is atmospheric, everything is clean, the service is excellent. For children there is a menu with mini burgers.",
                    "St. Petersburg, Sadovaya street, 62 ","59.921092","30.301836","r42");

            Insert_To_RESTAURANTS_BARS("Babe’s Bakery", "A small cozy coffee shop with delicious desserts and coffee. Desserts and pastries are fresh, there is a choice. Coffee for every taste.",
                    "St. Petersburg, Marata street, 30","59.926365","30.352600","r43");

            Insert_To_RESTAURANTS_BARS("C.A.K.E. Торты и Сладости от Анны Красовской", "Confectionery with the most unusual desserts in St. Petersburg. Anna Krasovskaya's confectionery is located far from the noisy tourist streets. But despite this, the cafe wins hearts with its bright design on the outside: a pink retro car in flowers and an amazing design inside. For author's desserts come here from all over the city.",
                    "St. Petersburg, Academician Pavlova Street, 7","59.977968","30.314378","r44");

            Insert_To_RESTAURANTS_BARS("Бурлящий котёл", "Cafe for Harry Potter fans. The menu is not very diverse, but there are a lot of games and you can have a great time with a group of friends.",
                    "St. Petersburg, Gagarinskaya street, 12","59.946247","30.342781","r45");

            Insert_To_RESTAURANTS_BARS("Lavanda Eclair", "Amazingly beautiful secluded place in the heart of the city. Highly creative delicious eclairs, friendly welcoming staff.",
                    "St. Petersburg, Zhukovsky street, 57","59.935681","30.362004","r46");

            Insert_To_RESTAURANTS_BARS("Erarta Restaurant", "The Erarta Restaurant is located on the 1st floor of the Erarta Museum of Contemporary Art on Vasilyevsky Island. The concept of the restaurant is fully consistent with the essence of the space in which it is located. Everything - dishes, serving, interior - is treated creatively here, as if it were a work of art.",
                    "St. Petersburg, 29th line Vasileostrovsky island, 2","59.931933","30.251814","r47");

            Insert_To_RESTAURANTS_BARS("КРЫША", "Very good location, great view! You can see both the palace and Isaac and the Admiralty. The very heart of the city. The service is good, the menu is compact, the portions are quite large.",
                    "St. Petersburg, Admiralteisky prospect, 8","59.935985","30.309743","r48");

            Insert_To_RESTAURANTS_BARS("Лево Право", "An excellent restaurant in the heart of St. Petersburg. Nice music, polite guys waiters, few items on the menu, but very tasty food. Inside the restaurant looks modern, European, cozy, in a somewhat minimalist design.",
                    "St. Petersburg, Moshkov lane, 6","59.943485","30.321751","r49");

            Insert_To_RESTAURANTS_BARS("The Buddy Cafe", "The Buddy Cafe is the crossroads of Russia and America, Europe and Asia: modern cuisine with sensory and Nordic elements in the atmosphere of the old capital, which combines the best cities in the world. The main philosophy of the institution is a laconic game with styles and traditions. On the one hand, there are large panoramic windows, reminding you that you are in the historical center of St. Petersburg, on the other hand, there is a chamber atmosphere and an open kitchen.",
                    "St. Petersburg, Lomonosov street, 14","59.927754","30.338144","r50");

            Insert_To_RESTAURANTS_BARS("Склад № 5", "A small restaurant in the former wine cellars of the famous Eliseev merchants shop. Cozy atmosphere, branded alcohol, exquisite cuisine, friendly waiters who will tell you everything and even more about this place.",
                    "St. Petersburg, Nevsky prospect, 56","59.934150","30.337806","r52");

            Insert_To_RESTAURANTS_BARS("Птицы", "The cafe prepares specialty coffee, proper tea, delicious breakfasts all day long, modern cuisine, and also wine! Everything is very beautiful, with attention to detail.",
                    "St. Petersburg, Malaya Podyacheskaya street, 2","59.926664","30.302075","r53");

            Insert_To_RESTAURANTS_BARS("OVERSIZE pizza", "A pizza restaurant. From a distance you will not see it, as the cafe is located in the courtyard. Moreover, when you enter the courtyard, you will have to pass one very similar place and trade shops with various cool hand-made items. Turn right and only then you will run into Oversize Pizza.",
                    "St. Petersburg, Grazhdanskaya street, 13-15","59.928489","30.312251","r54");

            Insert_To_RESTAURANTS_BARS("Север-Метрополь", "The legendary confectionery of St. Petersburg. A wonderful place with very affordable prices. The assortment is extensive - various pastries, cakes, desserts, etc. In addition to sweets, you can also eat something more serious - pies, salads, side dishes, etc. The food is always fresh and of good quality.",
                    "St. Petersburg, Nevsky prospect, 6","59.936952","30.314592","r55");

            Insert_To_RESTAURANTS_BARS("HI-SO Terrace", "Restaurant with a good view of St. Isaac's Cathedral. Excellent viewing platform.",
                    "St. Petersburg, Voznesensky prospect, 6","59.934814","30.308679","r56");

            Insert_To_RESTAURANTS_BARS("The Lounge at Lotte Hotel St. Petersburg", "The one-stop restaurant at the Lotte Hotel St. Petersburg on St. Isaac's Square. The interior of the institution is decorated in antique style: marble columns around the entire perimeter, a stained-glass dome depicting lilies. The menu includes hits of Mediterranean, Pan-Asian, Mexican and Russian cuisine. There is an extensive wine list with 200 items.",
                    "St. Petersburg, lane Antonenko, 2","59.931414","30.310631","r57");

            Insert_To_RESTAURANTS_BARS("Rterrace", "Beautiful view from the window on St. Isaac's Cathedral. Friendly staff. Cozy atmosphere, clean, beautiful. Large portions, very tasty food.",
                    "St. Petersburg, Pochtamtskaya street, 4","59.932733","30.304554","r58");

            Insert_To_RESTAURANTS_BARS("Мансарда", "A quality restaurant with a wonderful view of St. Isaac's Cathedral. Nice staff, good menu with lots of seafood. To get to the restaurant, you need to go almost to Gazpromneft, turn left into the elevator and go straight into it.",
                    "St. Petersburg, Pochtamtskaya street, 3-5","59.932988","30.303650","r59");

            Insert_To_RESTAURANTS_BARS("Terrassa", "A good place with decent cuisine, corresponding to the level of prices in the establishment. In good weather, you should definitely sit on the terrace with a view of Kazansky, and for cool weather there is also an indoor hall.",
                    "St. Petersburg, Kazanskaya street, 3","59.933869","30.322663","r60");

            Insert_To_RESTAURANTS_BARS("Volga-Volga", "A unique first-class restaurant-ship with an open deck, daily cruises along the Neva, across the famous bridges of St. Petersburg: Palace, Birzhevoy, Tuchkov, Blagoveshchensky, Sampsonievsky along the unique embankments: Admiralteyskaya, Universitetskaya, Dvortsovaya. It remains only to enjoy with bated breath.",
                    "St. Petersburg, Petrovskaya embankment, opposite house 8","59.953690","30.335846","r61");

            Insert_To_RESTAURANTS_BARS("Корюшка", "The restaurant hall offers a beautiful view of the Neva, the Winter Palace and so on. The view from the restaurant is especially beautiful in the evening. Beautiful illumination of buildings creates a sense of celebration. There is a children's room. There are many seats, the place is popular, and there are many people.",
                    "St. Petersburg, Peter and Paul Fortress, 3","59.948080","30.311243","r62");

            Insert_To_RESTAURANTS_BARS("Mais", "Interesting and atmospheric place from Ginza Project. The restaurant is located on the third floor of the Tinkoff Arena. Nice design, nice atmosphere. variety of food. There are snacks, salads, rolls, seafood, side dishes, desserts, drinks. From the window there is a view of the Lakhta Center, there is a summer terrace.",
                    "St. Petersburg, Primorsky prospect, 80 ","59.989013","30.188511","r63");

            Insert_To_RESTAURANTS_BARS("Москва", "Nice cozy restaurant, positioning itself as for the whole family. Food and service are top notch. On the highway, a chic panoramic view of Nevsky Prospekt.",
                    "St. Petersburg, Nevsky prospect, 114-116","59.931699","30.359280","r64");

            Insert_To_RESTAURANTS_BARS("Юность", "An excellent restaurant in a quiet cozy place of St. Petersburg. After a meal, you can take a walk through the beautiful courtyards of the area. The observation deck of the restaurant is not replete with very beautiful views, but there is something to see.",
                    "St. Petersburg, Savushkina street, 21","59.986000","30.285837","r65");

            Insert_To_RESTAURANTS_BARS("Джангл", "Stylish cafe in a quiet St. Petersburg courtyard. Very nice atmosphere inside. The staff is polite, friendly. Cooked quickly and very tasty.",
                    "St. Petersburg, Griboyedov Canal Embankment, 18-20","59.934240","30.327068","r66");

            Insert_To_RESTAURANTS_BARS("Sunday Ginza", "A restaurant with good food and a beautiful location! View of the sailboats, the opportunity to go to the water and walk on the sand. Diverse menu, extensive tea and wine list. Good service.",
                    "St. Petersburg, Southern road, 4, building 2","59.967284","30.244626","r67");

            Insert_To_RESTAURANTS_BARS("Карл и Фридрих", "An excellent pub where you can sit with a large and friendly company. You can also come with a girlfriend, wife and children. Large and beautiful courtyard. It's very atmospheric inside.",
                    "St. Petersburg, South road, 15","59.969915","30.232523","r68");

            Insert_To_RESTAURANTS_BARS("Русская рыбалка", "Great location overlooking the water. Located near the bay. Comfortable tables and furniture, a large heated veranda. Delicious dishes, interesting author's presentation.",
                    "St. Petersburg, South road, 11","59.969296","30.233185","r69");

            Insert_To_RESTAURANTS_BARS("Больше кофе", "Very cute place in the park with delicious desserts, coffee and tea. Pumpkin pie is decent, brownie is a bit dry. From unsweetened there is pita bread with spinach, cheese, sun-dried tomatoes and tuna. The very location of the coffee house is very interesting: it is located in the park and in the grotto. There is a veranda around the grotto (there are chairs with tables that resemble Parisian chairs in the Tuileries garden, there are just chairs by the fountain, on the railings of which metal trays are nailed).",
                    "St. Petersburg, Alexander Park, 3","59.954480","30.320607","r70");

            Insert_To_RESTAURANTS_BARS("La Vue", "Great view. Well, this is the main feature of the restaurant. Magnificent interior and terrace, dizzying beauty from it in summer. Friendly staff, good food, especially desserts.",
                    "St. Petersburg, Pirogovskaya embankment, 5/2 Hotel St. Petersburg, floor 10","59.956997","30.341649","r71");

            Insert_To_RESTAURANTS_BARS("Старая таможня", "The restaurant is located next to the Kunstkamera. Historical place, wonderful atmosphere. Wax figures of customs officers of the Russian Empire nicely complement the atmosphere. Quality food, very friendly staff.",
                    "St. Petersburg, Birzhevoy proezd, 2","59.941768","30.303156","r72");

            Insert_To_RESTAURANTS_BARS("Kuznyahouse", "Cozy restaurant on New Holland Island. Interesting menu, delicious desserts. A cozy, atmospheric restaurant with a great selection of dishes and a pleasant entourage. Great cocktails and friendly staff.",
                    "St. Petersburg, Admiralteisky Canal Embankment, 2","59.929464","30.288765","r73");

            Insert_To_RESTAURANTS_BARS("Ronny", "Very simple, but at the same time original place. One of the few places that stand out against the backdrop of the market is a Japanese restaurant. Interesting cuisine, Asian dishes with unusual accents.",
                    "St. Petersburg, Admiralteisky Canal Embankment, 2","59.929489","30.288293","r74");


            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }

    }

    public void Insert_To_Museums (String Museum_Name, String Museum_Info, String Museum_Address,
                                   String Museum_Latitude, String Museum_Longitude, String Museum_Img_source){
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.Museum_NAME, Museum_Name);
        cv.put(DBHelper.Museum_INFO, Museum_Info);
        cv.put(DBHelper.Museum_ADDRESS, Museum_Address);
        cv.put(DBHelper.Museum_LATITUDE, Museum_Latitude);
        cv.put(DBHelper.Museum_LONGITUDE, Museum_Longitude);
        cv.put(DBHelper.Museum_IMG_SOURCE, Museum_Img_source);
        db.insert(DBHelper.TABLE_MUSEUMS, null, cv);
    }

    public void Insert_Mus(){
        db.beginTransaction();
        try {
/*1*/       Insert_To_Museums("Museum-apartment of A. S. Pushkin","The apartment of the first poet of Russia. The only memorial apartment of A. S. Pushkin in St. Petersburg is dedicated to the last, most dramatic, period of the poet's life. The museum is housed in the former mansion of the princes Volkonsky.",
                    "St. Petersburg, embankment of the river Moika, 12","59.941206","30.321121",
                    "museum_push");

            /*2*/Insert_To_Museums("Church of the Savior Not Made by Hands","In 1826, a “sad chariot” was installed on the ground floor, on which the body of Alexander I was delivered. Later transferred to the museum. The church is also known for the fact that on February 1, 1837, the funeral of Alexander Sergeevich Pushkin took place in it.",
                    "St. Petersburg, Konyushennaya Square, 1",
                    "59.941659","30.326134", "m2");

/*3*/       Insert_To_Museums("Print Museum","A house where today you can get acquainted with all the stages of the formation and development of Russian book printing, see unique and at the same time working exhibits, as well as during master classes make a notebook, booklet or bind a book with your own hands.",
                    "St. Petersburg, embankment of the river Moika 32",
                    "59.939034","30.320651", "m3");

            /*4*/Insert_To_Museums("State Academic Chapel","The oldest Russian professional musical institution. Here, for the first time in Russia, all the main directions of musical performance and musical education consistently arose.",
                    "St. Petersburg, embankment of the river Moika 20",
                    "59.940285","30.320910", "m4");
//////////////////////////////////////////
            /*5*/Insert_To_Museums("Cathedral of St. Mary of the Evangelical Lutheran Church of Ingria ","The first community on the territory of modern St. Petersburg was formed in the 1630s in the city of Nien and was part of the Lutheran Church of Sweden. It was founded as a united Swedish-Finnish community.",
                    "St. Petersburg, Bolshaya Konyushennaya st. 8A",
                    "59.938233","30.323891", "m5");

            /*6*/Insert_To_Museums("Lutheran Church of Saints Peter and Paul","The Church of Saints Peter and Paul (also known as Petrikirche, German Petrikirche) is the largest Lutheran church in Russia, located in St. Petersburg. It was built by the brother of the famous artist Karl Bryullov, Alexander. And Karl decorated it with his \"Crucifixion\".",
                    "St. Petersburg, Nevsky prospect, 22-24",
                    "59.936775","30.323923", "m6");

            /*7*/Insert_To_Museums("Swedish Church of St. Catherine","Among the parishioners of the church were the Nobel family and the architect Lidval, the jeweler Carl Faberge. Karl Mannerheim, the future Russian general and president of Finland, was married in this church.",
                    "St. Petersburg, Malaya Konushennaya street, 1, corner of Swedish lane",
                    "59.938454","30.325485", "m7");

            /*8*/Insert_To_Museums("Home of the Dutch Reformed Church","The architect was Pavel Petrovich Zhako, a master who participated in the construction of the English Circus at the Simeonovsky Bridge, the building of the Nobility Assembly (designed by Rossi), and several St. Petersburg tenement houses.",
                    "St. Petersburg, Nevsky prospect 20",
                    "59.936332","30.320448", "m8");

            /*9*/Insert_To_Museums("House of the Singer Company","The House of the Singer Company (also known as the House of the Book) is the most famous building in the Art Nouveau style, which was built in 1902-1904 according to the design of the architect Pavel Syuzor for the Joint Stock Company Singer in Russia. Now at the very top is the office of Vkontakte.",
                    "St. Petersburg, Nevsky prospect 28",
                    "59.935727","30.325933", "m9");

            /*10*/Insert_To_Museums("Barometer clock","Electronic barometer clock showing the time, day of the week and year. This unique outdoor barometer clock shows not only the time, but also atmospheric pressure and air temperature. They document this data on rolls of paper so you can look at the history of the weather.",
                    "St. Petersburg, Malaya Konushennaya st. 5",
                    "59.937423","30.325004", "m10");

            /*11*/Insert_To_Museums("Museum-apartment of Zoshchenko M.M.","In this house, in the so-called \"writer's superstructure\" Zoshchenko lived at the peak of his fame - since 1934, occupying a 5-room apartment (No. 122).",
                    "St. Petersburg, Malaya Konushennaya, 4/2",
                    "59.937870","30.326110", "m11");

            /*12*/Insert_To_Museums("Museum of Soviet slot machines","Private historical interactive museum, which contains a collection of slot machines produced in the USSR since the mid-1970s. Museum visitors receive 15-kopeck coins at the entrance and use them to launch slot machines. The ticket price also includes an excursion.",
                    "St. Petersburg, Konyushennaya Square 2B",
                    "59.940150","30.326909", "m12");

            /*13*/Insert_To_Museums("Kazan Cathedral","In this huge, semicircular, sprawling cathedral with a mighty Corinthian colonnade and a majestic dome, the most revered icon in the capital was kept - the Kazan Mother of God, before which the tsar, and the proud nobleman, and the humble commoner knelt. Of the many lists of the miraculous image, only St. Petersburg and Moscow enjoyed fame throughout the Empire. The cathedral is the burial place of Kutuzov, the winner of Napoleon's army in the war of 1812. Also in the cathedral are preserved 5 Napoleonic standards and one banner, as well as the keys to Bremen, Lübeck, Aven, Mons, Nancy and Gertrudenberg.",
                    "St. Petersburg, Kazanskaya square",
                    "59.934602","30.324622", "m13");

            /*14*/Insert_To_Museums("Mertens Trading House","A trading house built specifically for the owner of a large fur company, Mertens F. L.",
                    "St. Petersburg, Nevsky prospect 21",
                    "59.935833","30.322157", "m14");

            /*15*/Insert_To_Museums("Stroganov Palace","Rastrelli F. B. designed the palace in such a way that both facades (both overlooking Nevsky Prospekt and overlooking the Moika River embankment) have a similar composition. The construction of the palace was carried out at an unimaginable pace for those times. Empress Elizaveta Petrovna herself attended the housewarming party. She was so fascinated by the palace that she celebrated her next birthday at the Stroganovs. The dynasty continued to own it until 1918.",
                    "St. Petersburg, Nevsky prospect, 17 / nab. Moiki, 46",
                    "59.935811","30.320300", "m15");

            /*16*/Insert_To_Museums("Palace of Razumovsky","The palace was built by order of the Hetman of Ukraine and President of the Academy of Sciences Kirill Razumovsky, brother of the favorite of Empress Elizabeth Petrovna. Once upon a time, large-scale balls and masquerades were held here, for which 2000 people gathered. Now within its walls is the Russian State Pedagogical University. A.I. Herzen.",
                    "St. Petersburg, Moika Embankment 48-50-52",
                    "59.934773","30.320310", "m16");

            /*17*/Insert_To_Museums("Russian Geographical Society","To collect and send the best young forces of Russia to a comprehensive study of their native land - such a mission was entrusted by Emperor Nicholas 1 to the Russian Geographical Society, established in 1845. The organization, which brought together lovers of geography, scientists and researchers, did not stop its work for a day - from the moment of its foundation to the present time, and its contribution to world geographical science can hardly be overestimated.",
                    "St. Petersburg, Grivtsova lane 10A",
                    "59.931162","30.313874", "m17");

            /*18*/Insert_To_Museums("Mariinsky Palace","One of the palaces of St. Petersburg, an important part of the ensemble of St. Isaac's Square. Built by order of Emperor Nicholas 1 for his daughter Maria for her marriage. Inside is a unique ramp. Along with the Winter Palace and the Tauride Palace, it is one of the three \"political\" palaces in St. Petersburg, the center of events in 1917 and 1991. Since 1994, it has been the seat of the city parliament - the Legislative Assembly of St. Petersburg.",
                    "St. Petersburg, St. Isaac's Square 6",
                    "59.930692","30.309786", "m19");

            /*19*/Insert_To_Museums("House of the architect Auguste Montferrand","The architect lived in this house during the construction of St. Isaac's Cathedral.",
                    "St. Petersburg, Embankment of the river Moika 86",
                    "59.934416","30.300719", "m20");

            /*20*/Insert_To_Museums("Yusupov Palace","All Russian monarchs have been here, from Nicholas 1 to Nicholas 2. Glinka, Viardot, Liszt, Chaliapin, Chopin performed on the stage of his theater. On the night of December 16 (30), 1916, Rasputin (a Siberian peasant who became a spiritual mentor and friend of the family of Emperor Nicholas 2.) was killed in the palace.",
                    "St. Petersburg, Embankment of the river Moika 96",
                    "59.929539","30.298941", "m21");

            /*21*/Insert_To_Museums("State Academic Mariinsky Theater","Russian Opera and Ballet Theater in St. Petersburg, one of the leading musical theaters in Russia and the world. Named after the wife of Alexander II, Empress Maria Alexandrovna. The curtain in the theater repeats the design of the Empress's coronation dress. One of the oldest musical theaters in Russia. Here, such artists as Matilda Kshesinskaya, Anna Pavlova, Vatslav Nijinsky, Galina Ulanova, Rudolf Nureyev, Mikhail Baryshnikov shone on the stage.",
                    "St. Petersburg, Theater Square 1",
                    "59.925776","30.296354", "m22");

            /*22*/Insert_To_Museums("Rimsky-Korsakov Conservatory","The first graduate of the Conservatory in composition was Pyotr Ilyich Tchaikovsky, who graduated in 1865 with a large silver medal.",
                    "St. Petersburg, Moika Embankment 98",
                    "59.927966","30.295903", "m23");

            /*23*/Insert_To_Museums("Nicholas Naval Cathedral","The first Naval Cathedral, traditionally serving the sailors of the Russian fleet.",
                    "St. Petersburg, Nikolskaya square 1 building 3",
                    "59.922602","30.300092", "m24");

            /*24*/Insert_To_Museums("Profitable house of Wege R. G. (House of the chocolate king)","The construction of the building began in 1914 according to the project of the architect Sergei Osipovich Ovsyannikov, a graduate of the Academy of Arts, a figure in the art deco era and the Soviet era. The customer was the \"Chocolate King\" R. G. Wege. The tenement house is made in an eclectic neoclassical style. The profitable house of Vega Robert Georgievich is famous for its majestic atlantes, which are inferior in size only to those located near the Hermitage.",
                    "St. Petersburg, Rimsky-Korsakov Avenue, 41 - emb. Kryukov channel, 14",
                    "59.923423","30.297434", "m25");

            /*25*/Insert_To_Museums("Pevchesky Bridge (Yellow)","It is a continuation of the Palace Square. The name comes from the fact that the bridge rests against the gates of the Singing Chapel. One of the so-called colored bridges in the city.",
                    "St. Petersburg, Pevchesky bridge",
                    "59.940044","30.319387", "m26");

            /*26*/Insert_To_Museums("Green bridge","Nevsky Prospekt passes through the bridge. In the 1730s it was painted green, hence the name Green. In 1768, another name appeared - \"Policeman\", because of the nearby city police department (later this house was occupied by the Court Hospital). Since 1777, the St. Petersburg general-police chief N. I. Chicherin lived near the bridge. One of the so-called colored bridges in the city.",
                    "St. Petersburg, Nevsky prospect",
                    "59.936111","30.319677", "m27");

            /*27*/Insert_To_Museums("Red bridge","This is the only cast-iron bridge across the Moika among the bridges built according to the standard design of V. I. Geste, which has preserved its historical appearance. The name of the bridge was given by the color of the crossing. One of the so-called colored bridges in the city.",
                    "St. Petersburg, Embankment of the Moika River",
                    "59.932987","30.315338", "m28");

            /*28*/Insert_To_Museums("Blue bridge","It is the widest (97.3 m) bridge in the city. Included in the ensemble of St. Isaac's Square. At the same time, the bridge is “invisible”: due to its record width, it is perceived as part of the square.",
                    "St. Petersburg, Antonenko Lane, 5",
                    "59.931864","30.309463", "m29");

            /*29*/Insert_To_Museums("Pochtamsky bridge","The canvas of the bridge is supported by chains, which are fixed in the abutments with the help of openwork metal \"quadrants\", divided into four sectors each. These metal quadrants rest on metal obelisks. The bridge is named after the nearby building of the Main Post Office, as well as the nearby Post Office Street and Post Office Lane. After this reconstruction, the cast-iron obelisks and chains finally ceased to support the bridge, while they were left as a decorative decoration. Only three chain suspension bridges have survived in St. Petersburg. All of them are pedestrian: Bankovsky, Lviny and Post Office.",
                    "St. Petersburg, Embankment of the Moika River",
                    "59.930494","30.300803", "m30");

            /*30*/Insert_To_Museums("kissing bridge","One of the iconic places in St. Petersburg, which has acquired legends due to its name. The name of the bridge came in 1788 by the name of the merchant of the 3rd guild Nikifor Vasilyevich Potseluev, the owner of the drinking house \"Kiss\" on the left bank of the Moika River, at the corner of the present Glinka Street.",
                    "St. Petersburg, Embankment of the Moika River",
                    "59.928167","30.295045", "m31");

            /*31*/Insert_To_Museums("Lion Bridge","An outstanding monument of bridge building architecture of the first quarter of the 19th century. One of the three surviving pedestrian chain bridges in St. Petersburg (along with the Bank and Post Office bridges). The Lion Bridge got its name from four cast-iron sculptures of lions by the sculptor P. P. Sokolov, located at the corners of the bridge.",
                    "St. Petersburg, Embankment of the Griboyedov Canal",
                    "59.926882","30.301439", "m32");

            /*32*/Insert_To_Museums("Bank bridge","It got its name because it led to the entrance to the Assignation Bank (today the University of Economics and Finance). This is one of the three suspension bridges in the city, along with Lvin and Post Office. Chain structures are inside the cast-iron griffins. The body of a lion, the wings of an eagle. Symbolizes the unity of mind and strength.",
                    "St. Petersburg, Embankment of the Griboyedov Canal",
                    "59.932153","30.325013", "m33");

            /*33*/Insert_To_Museums("Summer Garden and Summer Palace of Peter 1","The Summer Palace was built from 1710 to 1714 on the banks of the Fontanka on the site of Peter's wooden summer house that had stood here since 1703. In 1711, the Swan Canal was dug along the borders of the summer garden to drain the area. Water for the fountains succumbed from the nameless Yerik. In Peter's time, the Summer Garden occupied a larger area than now. The garden was closed to the public. It was possible to get there only at the invitation of Peter. Various plants from all over the world were purchased for the garden.",
                    "St. Petersburg, Palace embankment 2A",
                    "59.945120","30.335631", "m34");

            /*34*/Insert_To_Museums("Peter-Pavel's Fortress","Such a fortress in such good condition has not been preserved anywhere else. She was one of the best in Europe at that time. Its walls could withstand the heaviest assault of the enemy. And although she did not have to take a direct part in the hostilities, her very existence became a reliable defense for the reclaimed lands. Built during the Great Northern War. Almost 15 thousand soldiers participated in the construction.",
                    "St. Petersburg, Peter, and Paul Fortress",
                    "59.950507","30.317397", "m35");

            /*35*/Insert_To_Museums("Cathedral and tomb in the name of the Apostles Peter and Paul","Before Peter 1, such Orthodox churches were not built in Russia (they were typical for Northern Europe): Russian and European traditions are combined in its remarkable architecture. A high multi-tiered bell tower topped with a spire adjoins the cathedral. All Russian emperors were buried here, starting with Peter 1. Only uncrowned members of the imperial family were supposed to be buried in the tomb. Before the revolution of 1917, 13 burials were made here.",
                    "St. Petersburg, Peter and Paul Fortress. Cathedral Square 1",
                    "59.950238","30.316374", "m37");

            /*36*/Insert_To_Museums("Boathouse","The little boat was built in 1688 and is called St. Nicholas. It was brought by the British as a gift to Tsar Alexei Mikhailovich, the father of Peter 1. In 1688, Peter found it in Izmailovo. After minor corrections, it was lowered to the Yauza. And here Peter mastered the control of the boat on it. They call him \"Grandfather of the Russian Navy\".",
                    "St. Petersburg, Peter and Paul Fortress 3 part",
                    "59.950333","30.315313", "m38");

            /*37*/Insert_To_Museums("Money yard","One of the oldest industrial enterprises in our city. Initially, he was in Moscow, and in 1724, after being transferred to St. Petersburg, he settled in the Naryshkin and Trubetskoy bastions. It is here that since the time of Peter the Great, when the first Russian orders were established, Russian awards have been created.",
                    "St. Petersburg, Peter and Paul Fortress 6A",
                    "59.949446","30.314807", "m39");

            /*38*/Insert_To_Museums("Сommandant's house","The exposition \"History of St. Petersburg - Petrograd\" was organized in the premises of the Commandant's House. History of Petersburg-Petrograd. 1703-1918\" (Commandant's House). Based on authentic items from the unique collection of the museum, this exhibition presents the daily life of old St. Petersburg and St. Petersburg residents from the founding of the city to the revolutionary events of 1917.",
                    "St. Petersburg, Peter and Paul Fortress 4",
                    "59.949531","30.318629", "m40");

            /*39*/Insert_To_Museums("Memorial sign at the site of the founding of St. Petersburg","Installed on the roof of the Sovereign's bastion of the Peter and Paul Fortress. It was from here that the construction of the city began.",
                    "St. Petersburg, Peter and Paul Fortress. The sovereign's bastion",
                    "59.949938","30.321464", "m41");

            /*40*/Insert_To_Museums("Monument to the Hare","Installed on a log pile at the Ioannovsky Bridge, which leads to the Peter and Paul Fortress. A small sculpture was created for the 300th anniversary of St. Petersburg, as a tribute to the toponymic legend of Hare Island.",
                    "St. Petersburg, Ioannovsky bridge",
                    "59.952427","30.322777", "m42");

            /*41*/Insert_To_Museums("Monument Peter 1","The work of the sculptor Shemyakin M.M. The idea of creating a monument belonged to his friend Vladimir Vysotsky.",
                    "St. Petersburg, Peter and Paul Fortress",
                    "59.950142","30.317902", "m43");

            /*42*/Insert_To_Museums("Winter Palace. Hermitage","The main building of tsarist Russia. The masterpiece of the famous Rastrelli. In November 1917 the Winter Palace became part of the State Hermitage. The palace ensemble includes: the Imperial Winter Palace, the building of the Guards Corps, the building of the main headquarters with the Arc de Triomphe, the Alexander Column. The Hermitage consists of: the Winter Palace, the Small Hermitage, the Great or Old Hermitage, the New Hermitage, the Hermitage Theatre, the spare house of the Hermitage Palace, the Hermitage Garage.",
                    "St. Petersburg, Palace Square, 2",
                    "59.939865","30.314571", "m44");

            /*43*/Insert_To_Museums("Bronze Horseman","Monument to Peter 1 on the Senate Square. Made from bronze. The name \"copper\" was assigned to him thanks to the poem by Pushkin A.S. \"Bronze Horseman\". The pupils of Peter's eyes are made in the form of hearts.",
                    "St. Petersburg, Senate region",
                    "59.936430","30.302245", "m45");

            /*44*/Insert_To_Museums("Saint Isaac's Cathedral","The creation of the great Montferrand. The fourth temple is in honor of Isaac of Dalmatia, the patron saint of Emperor Peter 1, who was born on the day of his memory. For marshy soil, the building was unusually heavy, and 12,000 pitched pine piles had to be driven into the base of the foundation. The construction of the cathedral lasted for almost 40 years. It is called the huge Malachite box, a treasure trove of natural stone. Three finishes of the cathedral used valuable gems: jasper, lapis lazuli, Ural malachite, multi-colored marble.",
                    "St. Petersburg, St. Isaac's Square 4",
                    "59.934139","30.306240", "m46");

            /*45*/Insert_To_Museums("Admiralty","The first Russian shipyard on the Baltic Sea. The ship on the spire is one of the symbols of our city.",
                    "St. Petersburg, Admiralteyskaya embankment 2",
                    "59.937514","30.308508", "m47");

            /*46*/Insert_To_Museums("Alexander Column","The creation of Montferan, staged in honor of the victory of Alexander1 over Napoleon.",
                    "St. Petersburg, Palace Square",
                    "59.939054","30.315819", "m48");

            /*47*/Insert_To_Museums("Marble palace","Another royal residence. Built at the behest of Empress Catherine II for Count Orlov.",
                    "St. Petersburg, Millionnaya street 6",
                    "59.945203","30.326940", "m49");

            /*48*/Insert_To_Museums("Monument to Suvorov","Installed by order of Emperor Paul 1 in honor of the commander's victory over Napoleon's troops in Italy. Made during the lifetime of the great commander.",
                    "St. Petersburg, Suvorovskaya Square",
                    "59.945931","30.329903", "m50");

            /*49*/Insert_To_Museums("Monument to Alexander 3","Monument to Alexander 3 The author - Paolo Trubetskoy - found the monument not particularly successful. When a scandal erupted and he was asked: “What kind of idea did you want to invest in a monument?”, He laughed it off: “I'm not interested in politics. I depicted one animal on another\".",
                    "St. Petersburg, 5A Millionnaya Street",
                    "59.945386","30.327479", "m51");

            /*50*/Insert_To_Museums("Atlanta","Sculptures decorating the portico of the New Hermitage. One of the symbols of St. Petersburg.",
                    "St. Petersburg, Millionnaya street 35",
                    "59.941124","30.317664", "m52");

            /*51*/Insert_To_Museums("Museum of the Political Police of Russia","The only public non-departmental museum in the country dedicated to the history of domestic special services.",
                    "St. Petersburg, Gorokhovaya street, house number 2",
                    "59.936634","30.311072", "m53");

            /*52*/Insert_To_Museums("Rumyantsev Mansion","The Rumyantsev Museum, the first private public museum in Russia, was opened in 1831. The house housed a huge library composed of collections of Russian and Slavic manuscripts, Russian books of church and civil printing, foreign publications and maps. The museum kept collections of coins and medals, a collection of clothes and things of the islanders, brought from a round-the-world trip by captain Otto Kotzebue.",
                    "St. Petersburg, Angliskaya Embankment, 44",
                    "59.932797","30.289467", "m54");

            /*53*/Insert_To_Museums("Bobrinsky Palace","In 1798, Alexei Grigoryevich Bobrinsky, the illegitimate son of Empress Catherine II and Grigory Orlov, became the first owner of the estate from the Bobrinsky family. Tours are held periodically in the palace (by appointment).",
                    "St. Petersburg, Galernaya street 58-60",
                    "59.930070","30.285050", "m55");

            /*54*/Insert_To_Museums("Traction substation No. 11, known as the Blockade Substation","On December 8, 1941, regular tram traffic in the city stopped. For a month, individual carriages were still moving along the streets, but in January 1942, with the interruption of the supply of electricity, the movement of electric transport stopped completely. 52 trains remained on the streets all winter. For three and a half months, exhausted from hunger and suffering, people had to move around the city only on foot, even if they worked far from home. On March 8, 1942, voltage began to flow from the Krasny Oktyabr hydroelectric power station.",
                    "St. Petersburg, embankment of the Fontanka River, 3",
                    "59.939092","30.340746", "m56");

            /*55*/Insert_To_Museums("Radio Museum","Place of work of Olga Bergolts in besieged Leningrad. In the museum we see photographs of those people - radio journalists, announcers, actors, musicians - who performed their feat simply and casually, together with the army, sailors of the Baltic, all the defenders of the city. Various equipment is also presented here. wartime. But you experience the strongest feelings when you enter the studio and hear the sound of a siren.",
                    "St. Petersburg, Italian street, 27",
                    "59.935703","30.338550", "m57");

            /*56*/Insert_To_Museums("Great Hall of the St. Petersburg Philharmonic. Shostakovich","It was here that on August 9 in besieged Leningrad, the day when, according to Hitler's plan, the city was supposed to fall from the blockade, the premiere of the famous Shostakovich symphony took place.",
                    "St. Petersburg, Italian street, 9",
                    "59.936487","30.331916", "m58");

            /*57*/Insert_To_Museums("Chizhik-Pyzhik","11 cm and 5 kg is one of the smallest monuments in St. Petersburg. It is authentically known that it was developed by Rezo Gabaridze, a Georgian screenwriter and film director. There is an opinion that the creator of the bronze bird named it so because the uniforms of the students of the Imperial School of Law resembled the color of siskins in their colors, and the famous rhyme was composed in honor of their unbridled festivities in a tavern nearby.",
                    "St. Petersburg, Embankment of the Fontanka River",
                    "59.941700","30.338029", "m59");

            /*58*/Insert_To_Museums("Mikhailovsky Castle","The decree on the construction of the castle - a dream of many years, was issued in the very first month of the reign of Paul I. The building was erected on the site of the wooden Summer Palace of Elizabeth Petrovna, created by the architect Rastrelli, where on September 20, 1754, Grand Duchess Ekaterina Alekseevna gave birth to Grand Duke Pavel Petrovich and where during coup in 1762, his mother was proclaimed empress. Here, on the night of March 11-12, the life of the emperor was interrupted.",
                    "St. Petersburg, Sadovaya street, 2",
                    "59.940734","30.337604", "m60");

            /*59*/Insert_To_Museums("The circus. Museum of Circus Art","One of the most beautiful circuses in Europe. In 2015, in honor of the bicentenary of Gaetano Ciniselli, the building was returned to its original name - Cinizelli Circus. The museum's funds were created and are being created to a greater extent thanks to circus performers who donate photographs, posters, programs, costumes and other circus material.",
                    "St. Petersburg, Embankment of the Fontanka River 3",
                    "59.938304","30.341508", "m61");

            /*60*/Insert_To_Museums("Church of the Savior on Blood","It was built in memory of the fact that on this place on March 1 (13), 1881, as a result of an assassination attempt, Emperor Alexander II was mortally wounded (the expression on the blood indicates the blood of the king). The temple was built as a monument to the martyr tsar with funds collected from all over Russia.",
                    "St. Petersburg, Griboedov Canal Embankment, 2B, lit.A",
                    "59.940079","30.328641", "m62");

            /*61*/Insert_To_Museums("Mikhailovsky Palace. Russian Museum","The largest museum of Russian art. The collection originates from works received by 1898 from the Academy of Arts (122 paintings), the Hermitage (80 paintings), the Winter Palace, suburban palaces - Gatchina and Alexander (95 paintings), as well as those acquired in private collections.",
                    "St. Petersburg, Inzhenernaya street, 2-4A",
                    "59.938846","30.332424", "m64");

            /*62*/Insert_To_Museums("Mikhailovsky Theater","The entire St. Petersburg world gathered in the theater, including the court and the imperial family. French and German troupes performed on the stage of the theater, and maestro Johann Strauss more than once stood at the conductor's stand.",
                    "St. Petersburg, Arts Square, 1",
                    "59.937911","30.329238", "m65");

            /*63*/Insert_To_Museums("Benois Corps","Initially, the building was called the Palace of Arts and was intended to host exhibitions of various art associations and unions. Now a branch of the Russian Museum.",
                    "St. Petersburg, Engineering street, 2–4",
                    "59.938738","30.328855", "m66");

            /*64*/Insert_To_Museums("Ethnographical museum","One of the largest ethnographic museums in Europe.",
                    "St. Petersburg, Engineering street, 4/1",
                    "59.937908","30.334374", "m67");

            /*65*/Insert_To_Museums("Museum-apartment of Brodsky I. I. ","Brodsky I.I. - a famous artist, a favorite student of I.E. Repin, lived in this apartment for the last 15 years of his life, from 1924 to 1939. In 1949, a museum was opened here, which presents a unique collection of Russian artists, collected by I.I. Brodsky, and the work of the artist himself",
                    "St. Petersburg, Arts Square, 3",
                    "59.942801","30.350285", "m68");

            /*66*/Insert_To_Museums("Museum of microminiatures \"Russian Levsha\".","The collection is unique in that all exhibits are smaller than a millimeter. Micro-objects can be examined only with the help of magnifying devices - microscopes mounted in exhibition forms. The collection of works is made, literally, from the dust of gold, silver, platinum and ordinary household, gray - under high magnification, rainbow-colored.",
                    "St. Petersburg, Italian street, 35",
                    "59.935471","30.340569", "m69");

            /*67*/Insert_To_Museums("Basilica of Saint Catherine of Alexandria","Catholic church in St. Petersburg, one of the oldest Catholic churches in Russia. Architectural monument. The parishioner of the temple was the famous architect Montferrand, the builder of St. Isaac's Cathedral. Here he married and baptized his son. Here his body was buried after death, after which his widow took the coffin with the body of her husband to France.",
                    "St. Petersburg, Nevsky prospect, 32–34",
                    "59.935732","30.329144", "m70");

            /*68*/Insert_To_Museums("Church of Saint Catherine","Temple of the Armenian Apostolic Church in St. Petersburg. The church became the center of Armenian culture in St. Petersburg: a printing house and a national school were opened under it.",
                    "St. Petersburg, Nevsky prospect, 40–42",
                    "59.935404","30.332304", "m71");

            /*69*/Insert_To_Museums("Passage","One of the oldest and largest trading houses in St. Petersburg.",
                    "St. Petersburg, Nevsky prospect, 48",
                    "59.935283","30.334453", "m72");

            /*70*/Insert_To_Museums("Mikhailovsky Manege","Since 2005, the State Institution \"Winter Stadium\" has been transformed into the GUDO SDUSHOR \"Academy of Athletics\" with over 800 athletes involved in it. The school has 8 honored coaches of Russia. In 2007, the combined team of the school was the second in the Russian championship among the SDUSHOR.",
                    "St. Petersburg, Inzhenernaya street, 11",
                    "59.937136","30.339041", "m74");

            /*71*/Insert_To_Museums("Hygiene Museum","The exposition of the Museum of Hygiene is formed in such a way as to give visitors information about the most common dangers to human life and health in the rapidly changing world of the 21st century.",
                    "St. Petersburg, Italian street, 25",
                    "59.935880","30.337335", "m75");

            /*72*/Insert_To_Museums("City Council building","If now the main bodies of city self-government of St. Petersburg are the Government and the Legislative Assembly, then earlier, in imperial times, their role was played by the City Duma, subject to the governor-general. The Duma was established in 1786. She dealt with urban issues, taxes and fees, medicine, education, trade, and so on. Now the museum of savings banks and a stunning observation deck.",
                    "St. Petersburg, Dumskaya street, 1-3",
                    "59.934273","30.329029", "m76");

            /*73*/Insert_To_Museums("Gostiny Dvor","A monument of history and architecture of the 18th century, in the past - the central wholesale Gostiny Dvor, since the beginning of the 20th century - a department store. It is under the protection of UNESCO.",
                    "St. Petersburg, Nevsky prospect 35",
                    "59.934089","30.333383", "m77");

            /*74*/Insert_To_Museums("The Wax Museum","This is a huge space, on the territory of which exhibits of different eras, themes and trends are presented. It will be interesting for people of all professions and ages.",
                    "St. Petersburg, Nevsky prospect 35",
                    "59.934340","30.331164", "m78");

            /*75*/Insert_To_Museums("Russian National Library Department of Manuscripts","The first publicly accessible national book depository in Russia, and now one of the largest libraries in the world.",
                    "St. Petersburg, Sadovaya street 18",
                    "59.932887","30.335642", "m79");

            /*76*/Insert_To_Museums("Monument to Catherine 2","Around the pedestal, there are nine figures of prominent figures of the Catherine era: Field Marshal Pyotr Rumyantsev-Zadunaisky, statesman Grigory Potemkin and commander Alexander Suvorov face Nevsky Prospekt, poet Gavriil Derzhavin and President of the Russian Academy Ekaterina Dashkova face the Anichkov Palace, Prince Alexander Bezborodko and President of the Russian Academy of Arts Ivan Betskoy - to the Public Library, polar explorer and naval commander Vasily Chichagov and statesman Alexei Orlov-Chesmensky - to the pediment of the Alexandrinsky Theater.",
                    "St. Petersburg, Ostrovsky Square",
                    "59.933334","30.337027", "m80");

            /*77*/Insert_To_Museums("Eliseevsky shop","The Eliseevsky store is one of the few museum stores in the world that not only provides customers with goods and services, but also immerses them in the atmosphere of a bygone era.",
                    "St. Petersburg, Nevsky prospect, 56",
                    "59.934150","30.337993", "m81");

            /*78*/Insert_To_Museums("Anichkov Palace","One of the imperial palaces of St. Petersburg, near the Anichkov bridge.",
                    "St. Petersburg, Nevsky prospect, 39",
                    "59.932999","30.339822", "m83");

            /*79*/Insert_To_Museums("Alexandrinsky Theater","One of the oldest drama theaters in Russia that has survived to this day.",
                    "St. Petersburg, Ostrovsky Square, 6",
                    "59.931800","30.336212", "m84");

            /*80*/Insert_To_Museums("Museum of Theater and Musical Art","The first museum in Russia dedicated to the history of the Russian theater. The museum's collection contains 450,000 exhibits that tell about dramatic, operatic and ballet art during its existence in Russia.",
                    "St. Petersburg, Ostrovsky Square, 6",
                    "59.931138","30.336656", "m85");

            /*81*/Insert_To_Museums("Vaganova Russian Ballet Academy","One of the oldest ballet schools in the world, the flourishing and worldwide recognition of the Russian ballet school is closely associated with its name.",
                    "St. Petersburg, Architect Rossi Street, 2",
                    "59.930476","30.335973", "m86");

            /*82*/Insert_To_Museums("Rossi street","The street is unique in its exact adherence to ancient canons - its width is equal to the height of its forming buildings (22 meters), and its length is exactly ten times greater - 220 meters.",
                    "St. Petersburg, Architect Rossi Street",
                    "59.930363","30.335544", "m87");

            /*83*/Insert_To_Museums("Vorontsov Palace on Sadovaya Street. Suvorov School","The current owners of the Vorontsov Palace, the Suvorov Infantry School, also organize balls here, which, like the old days, sparkle with the splendor of “epaulettes” and the beauty of youth in the luxurious halls of the old chancellor's house.",
                    "St. Petersburg, Sadovaya street, 26D",
                    "59.931475","30.331722", "m88");

            /*84*/Insert_To_Museums("Apraksin yard","An architectural complex in the central part of St. Petersburg, one of the largest historical shopping centers in the city. It occupies 14 hectares of territory bounded by Sadovaya and Lomonosov streets, the Fontanka embankment and Apraksin Lane, an architectural monument (regional). Named after the first owner of the land - Count Apraksin F.M.",
                    "St. Petersburg, Sadovaya street, 28-30k10",
                    "59.929890","30.326821", "m90");

            /*85*/Insert_To_Museums("Yusupov Palace","The Yusupov Palace on Sadovaya Street is the former palace of the Yusupov princes. Since November 1, 1810 - the first building of the Institute of the Corps of Railway Engineers. Now it is occupied by the Institute of Railway Engineers. Not to be confused with the palace of the same name on the Moika.",
                    "St. Petersburg, Fontanka river embankment, 115",
                    "59.922052","30.314660", "m91");

            /*86*/Insert_To_Museums("Rotunda","An unusual building in the form of a round building with a dome, columns located along the perimeter and a spiral staircase has become the most mysterious and mystical. For tourists unfamiliar with St. Petersburg, mysticism begins with the search for the address of the Rotunda.",
                    "St. Petersburg, Gorokhovaya street 57",
                    "59.925661","30.325860", "m93");

            /*87*/Insert_To_Museums("Museum of Defense and Siege of Leningrad","Museum of Memory. On December 4, 1943, the Military Council of the Leningrad Front adopted a resolution on the opening of the exhibition \"Heroic Defense of Leningrad\" in a short time. For its placement, the building of the former Agricultural Museum in the Salt Town was chosen.",
                    "St. Petersburg, Solyanoy lane 9",
                    "59.944371","30.340621", "m94");

            /*88*/Insert_To_Museums("Stirlitz Museum","A museum with beautiful interiors and an interesting collection of art objects, open not only to students of the academy, but to everyone.",
                    "St. Petersburg, Solyanoy lane 13-15",
                    "59.943655","30.341147", "m95");

            /*89*/Insert_To_Museums("Panteleimon Church","The order to consecrate the temple in the name of the Holy Great Martyr and healer Panteleimon was sent personally by Peter I. The emperor conceived this church as a memorial temple to the Russian fleet, in gratitude for two naval victories at Gangut on July 27, 1714 and at Grengam on July 27, 1720.",
                    "St. Petersburg, Pestel Street, 2A",
                    "59.942559","30.341107", "m96");

            /*90*/Insert_To_Museums("Mosaic courtyard","Almost everyone in the local residents of St. Petersburg knows about the Mosaic Courtyard on Tchaikovsky Street. However, not all tourists know it. But this is a real open-air museum. This site, one might say, has become a real creative laboratory of the famous artist and founder of the Small Academy of Arts Vladimir Vasilyevich Lubenko and his wards.",
                    "St. Petersburg, Tchaikovsky street, 2/7",
                    "59.947349","30.338925", "m97");

            /*91*/Insert_To_Museums("Coffee museum","The coffee museum is interesting not only for lovers of this drink, but also for anyone interested in history.",
                    "St. Petersburg, Shpalernaya street, 40АЕ",
                    "59.949504","30.362551", "m98");

            /*92*/Insert_To_Museums("The universe of water","The museum presents three expositions - \"The World of Water of St. Petersburg\", \"The Underground World of St. Petersburg\" and \"The Universe of Water\". The last two can only be visited with a guide (on weekdays there are excursions for organized groups, single visitors can view the expositions on weekend excursions).",
                    "St. Petersburg, Shpalernaya street, 56",
                    "59.949531","30.376097", "m99");

            /*93*/Insert_To_Museums("Smolny Cathedral","The Resurrection Smolny Cathedral has historically been a temple of educational institutions in St. Petersburg, a temple of students, therefore, the spiritual and moral education of youth is a priority for the clergy and laity of the temple. In the 1740s, Elizaveta Petrovna announced to a member of the Synod, Archbishop Simeon, that she wanted to build a majestic monastery on the site of the Smolny House (the palace in which she lived her childhood), where she would end her days in peace and quiet. The monastery complex was to include a temple with house churches and a bell tower and an institute for girls from noble families. Drawing up plans, facades and estimates was entrusted to the court chief architect Bartolomeo Francesco Rastrelli.",
                    "St. Petersburg, Rastrelli Square 1",
                    "59.948887","30.395266", "m100");

            /*94*/Insert_To_Museums("Tauride Palace","In the 1740s, Elizaveta Petrovna announced to a member of the Synod, Archbishop Simeon, that she wanted to build a majestic monastery on the site of the Smolny House (the palace in which she lived her childhood), where she would end her days in peace and quiet. The monastery complex was to include a temple with house churches and a bell tower and an institute for girls from noble families. Drawing up plans, facades and estimates was entrusted to the court chief architect Bartolomeo Francesco Rastrelli. The first owner of the Tauride Palace was His Serene Highness Prince Grigory Potemkin, a favorite of Catherine II.",
                    "St. Petersburg, Shpalernaya street, 47",
                    "59.947718","30.375989", "m101");

            /*95*/Insert_To_Museums("Museum of Suvorov A.V.","In fact, it is fair to consider it the first memorial museum in Russia, the exposition of which was originally dedicated to one person. Everything about the great Russian commander who did not lose a single battle is collected here - from lifetime portraits to awards and personal items.",
                    "St. Petersburg, Kirochnaya street, 43",
                    "59.943278","30.376584", "m102");

            /*96*/Insert_To_Museums("Tin Soldier Museum","The Museum of the Tin Soldier in St. Petersburg appeared quite recently, but has already managed to make so much noise that the whole country has learned about it. It became the first thematic exhibition in Russia, which is completely devoted to miniature toys and the process of their creation.",
                    "St. Petersburg, Kirochnaya street, 43",
                    "59.943086","30.375446", "m103");

            /*97*/Insert_To_Museums("Sheremetyevo Palace","Music Museum. The Fountain House is one of the most interesting sights of St. Petersburg, almost the same age as the city. The name \"Fountain House\" dates back to the 18th century. was assigned to the estate of the Counts Sheremetevs, built on a vast area between the Fontanka River embankment and Liteiny Prospekt. Now it is the Museum of Music, which is based on the largest collection of musical instruments in Russia from all over the world.",
                    "St. Petersburg, Fontanka embankment, 34",
                    "59.936528","30.345465", "m104");

            /*98*/Insert_To_Museums("Museum of Anna Akhmatova","For 30 years now, the staff of the Funds Department of the Anna Akhmatova Museum in the Fountain House has been collecting, studying, describing and cataloging unique items related to the history and culture of the Silver Age.",
                    "St. Petersburg, Liteiny prospect, 53",
                    "59.935931","30.346702", "m105");

            /*99*/Insert_To_Museums("Faberge Museum","Private museum in St. Petersburg, located in the Naryshkin-Shuvalov Palace. It has an unparalleled collection of Russian jewelry and arts and crafts of the 19th-20th centuries. The most valuable and famous items in the museum's collection are 9 imperial Easter eggs created by the firm of Carl Gustavovich Faberge.",
                    "St. Petersburg, Fontanka embankment, 21",
                    "59.934696","30.343193", "m106");

            /*100*/Insert_To_Museums("Beloselsky-Belozersky Palace","Anyone can visit the Palace of Princes Beloselsky-Belozersky. To do this, it is not even necessary to sign up for a tour, because the former residence today has a cultural center that regularly organizes theatrical, musical, dance and other events.",
                    "St. Petersburg, Nevsky prospect, 41",
                    "59.932782","30.345288", "m107");

            /*101*/Insert_To_Museums("Anichkov bridge","Interestingly, the design of the bridge is nothing special, but its “highlight” is a group of sculptures depicting the stages of taming a horse. The sculptures have long become symbols of the cultural capital; various urban legends are associated with them.",
                    "St. Petersburg, Nevsky prospect, 88",
                    "59.933194","30.343392", "m108");

            /*102*/Insert_To_Museums("Vladimir's Cathedral","The temple was built and consecrated in honor of the icon of the Mother of God, the Defender of the Russian land. Historians believe that thanks to her patronage, the cathedral remained unscathed until our times. Today, divine services, the sacraments of baptism and weddings are held here. At the end of his life, Fyodor Mikhailovich Dostoevsky was a frequent visitor to the church. He came here in the hope of remission of past sins. The temple is also famous for the fact that Arina Rodionovna, Pushkin's nanny, his faithful assistant and mentor, was buried here.",
                    "St. Petersburg, Vladimirsky prospect, 20",
                    "59.928204","30.348347", "m109");

            /*103*/Insert_To_Museums("Museum of F.M.Dostoevsky","One of the six Russian museums of Fyodor Mikhailovich Dostoevsky, located in St. Petersburg, in a house in Kuznechny Lane, where the writer first lived for a short time in 1846, and then spent the last years of his life.",
                    "St. Petersburg, Kuznechny lane 5",
                    "59.927364","30.350700", "m110");

            /*104*/Insert_To_Museums("Museum of the Arctic and Antarctic","It is the largest museum in the world, the collection of which (about 70 thousand exhibits) is dedicated to the polar theme. It presents archaeological monuments and relics related to the history of the development of the Northern Sea Route, including an archaeological collection of Pomor household items from the first half of the 17th century.",
                    "St. Petersburg, Marata street, 24A",
                    "59.927411","30.353555", "m111");

            /*105*/Insert_To_Museums("Gambling Museum","The special charm and atmosphere of the museum is added by the ability of a guide, a professional illusionist, who shows the most popular casino games and the main cunning tricks with cards and dice. There is an opportunity to play, even though you can’t take the winnings with you.",
                    "St. Petersburg, Marata street, 33",
                    "59.926098","30.351800", "m112");

            /*106*/Insert_To_Museums("Alexander Nevsky Lavra","In the Lavra there is the greatest shrine for the Russian people - the relics of the holy noble prince Alexander Nevsky. The grave of Mikhail Lomonosov is located at the Lazarevsky cemetery. By the beginning of the 20th century, many objects had accumulated in the monastery, donated or donated. In order to preserve all this and show it to the general public, the first project of the museum was created on the territory of the Alexander Nevsky Lavra, and then the museum itself. It bore the name of an ancient storage - a repository of antiquities.",
                    "St. Petersburg, Monastyrka river embankment, 1",
                    "59.921040","30.388210", "m114");

            /*107*/Insert_To_Museums("Planetarium №1","The largest in the world in terms of dome diameter. The format of its work is simple: you lie on an ottoman on the floor and watch relaxed animated films about the Universe, planets, the Moon, probe flights to comets, etc. on a huge screen.",
                    "St. Petersburg, Obvodny Canal embankment, 74",
                    "59.911533","30.330958", "m115");

            /*108*/Insert_To_Museums("Five corners","Unique place in the city. This is the unofficial name of the intersection in St. Petersburg, formed by the intersection of Zagorodny Prospekt with Razyezzhaya, Rubinstein and Lomonosov streets. The crossroads has existed since the 1760s. The architectural dominant of the intersection, which has become one of the iconic symbols of the city, is an apartment building with a turret.",
                    "St. Petersburg, Zagorodny avenue",
                    "59.926220","30.342448", "m116");

            /*109*/Insert_To_Museums("Front Chamomile","The most beautiful front door in the city. Profitable house of Eliseev.",
                    "St. Petersburg, Lomonosov street 14",
                    "59.927858","30.338347", "m117");

            /*110*/Insert_To_Museums("Derzhavin Estate Museum","The city estate consists of the poet's mansion, two twin outbuildings, a small guest building and a greenhouse.",
                    "St. Petersburg, Fontanka river embankment, 118",
                    "59.918985","30.310856", "m118");

            /*111*/Insert_To_Museums("Seven bridges","A unique place in our city. A bunch of seven bridges around which legends and fairy tales are composed.",
                    "St. Petersburg, Pikalov bridge",
                    "59.920999","30.298753", "m119");

            /*112*/Insert_To_Museums("Museum apartment of Blok A.A.","The museum consists of two parts: a memorial apartment on the 4th floor (apartment No. 21), created on unique authentic furnishings and decorations that belonged to the poet, and a literary exposition on the 2nd floor (apartment No. 23), which tells about his life and creativity.",
                    "St. Petersburg, Dekabristov street, 57",
                    "59.923546","30.282164", "m120");

            /*113*/Insert_To_Museums("Artillery Museum","The exposition in huge spacious halls is dedicated to military equipment of certain historical periods. Here you can see everything, from the guns of the time of Peter the Great, cast in bronze, and ending with the weapons of our time. When the future Emperor Peter the Great was not even 4 years old, Tsar Alexei Mikhailovich gave him a “funny” cannon, here it is just presented.",
                    "St. Petersburg, Alexander Park, 7",
                    "59.953941","30.313776", "m121");

            /*114*/Insert_To_Museums("Leningrad Zoo","A great place where you can combine a walk in the park, observing animals and getting interesting information about fairy tales about animals.",
                    "St. Petersburg, Aleksandrovsky park, 1",
                    "59.951522","30.308697", "m122");

            /*115*/Insert_To_Museums("Cruiser Aurora","The legendary cruiser is a symbol of revolution.",
                    "St. Petersburg, Petrogradskaya embankment 2",
                    "59.955501","30.337837", "m125");

            /*116*/Insert_To_Museums("House of Peter 1","The original house in which Peter lived during the laying of St. Petersburg. The modern museum exposition of the House of Peter I is represented by objects related to the time of Peter the Great, including memorial ones. Among them: a uniform dress of red cloth; cane of oriental work, casting of Peter's hand from an impression made at the Lipetsk iron foundry in 1707, boat-rope, chair of Peter 1.",
                    "St. Petersburg, Petrogradskaya embankment 6",
                    "59.953358","30.330894", "m126");

            /*117*/Insert_To_Museums("Lenfilm","A tour of Lenfilm is a journey through the halls of the oldest film studio, between archival documents and the ghosts of cinema reality. The guide, in the course of his story, introduces guests to the history of the country's oldest film studio, the memory of this place, and the riches of props workshops.",
                    "St. Petersburg, Kamennoostrovsky prospekt, 10",
                    "59.958004","30.317537", "m127");

            /*118*/Insert_To_Museums("Botanical Garden","The successor of the Pharmaceutical Garden that existed under Peter the Great. One of the oldest botanical gardens in Russia.",
                    "St. Petersburg, Professor Popov street, 2",
                    "59.969918","30.325370", "m128");

            /*119*/Insert_To_Museums("Museum of Author's Porcelain","The museum is waiting for visitors at 151 Obukhovskoy Oborony Avenue. Guests will learn the history of the plant from the 18th century to the present day and get acquainted with a unique collection of porcelain, which has no analogues in any country in the world.",
                    "St. Petersburg, Obukhovskoy Oborony Avenue, 15-12",
                    "59.879764","30.446777", "m129");

            /*120*/Insert_To_Museums("House Museum of Chaliapin F.I.","The F. I. Chaliapin Museum was opened on April 11, 1975 in the singer’s last St. Petersburg apartment. Here, on Aptekarsky Island, in the house 2-B on Permskaya Street (now Graftio Street), the great singer lived from 1915 to 1922, from here he went abroad forever.",
                    "St. Petersburg, Graftio street, 2B",
                    "59.974135","30.305691", "m130");

            /*121*/Insert_To_Museums("Boiler Kamchatka","Gained fame thanks to the work of the legendary rock musician Viktor Tsoi, leader of the Kino group; the boiler room after his death became a place of \"pilgrimage\" for fans.",
                    "St. Petersburg, Blokhin street, 15",
                    "59.951980","30.301245", "m132");

            /*122*/Insert_To_Museums("Museum of Artistic Glass","The Museum of Artistic Glass is a structural subdivision of the Elaginoostrovsky Palace Museum, which has a unique collection of art glass. The basis of the collection was a collection of works by the leading glass enterprise of the Soviet Union, the Leningrad Art Glass Factory, which was closed in 1996.",
                    "St. Petersburg, Yelagin island, 4B",
                    "59.980351","30.268431", "m133");

            /*123*/Insert_To_Museums("Yelagin Palace","One of the best monuments of the Empire era in Russia, Elagin Palace, an architectural gem of the palace and park ensemble on Elagin Island.",
                    "St. Petersburg, Yelagin island 4",
                    "59.980315","30.268452", "m134");

//            Insert_To_Museums("Icebreaker Krasen","One of the first icebreakers in the world.",
//                    "St. Petersburg, Lieutenant Schmidt embankment, line 23",
//                    "59.928669","30.268493", "m135");

            /*124*/Insert_To_Museums("Museum of Religion","Museum of ReligionThe State Museum of the History of Religion is the only one in Russia and one of the few museums in the world, the exposition of which presents the history of the emergence and development of religion.",
                    "St. Petersburg, Pochtamtskaya street, 14/5",
                    "59.931810","30.301373", "m136");

            /*125*/Insert_To_Museums("Menshikov Palace","Peter 1 called this palace the Embassy House (here they gave audiences to foreign ambassadors)[8] and spent almost all festive feasts and gala dinners there[7]. In the Menshikov Palace, the future Russian Empress Anna Ioannovna played a wedding with the Duke of Courland.",
                    "St. Petersburg, Universitetskaya embankment, 15",
                    "59.938841","30.296014", "m137");

            /*126*/Insert_To_Museums("Museum of Anthropology and Ethnography named after Peter the Great of the Russian Academy of Sciences","Founded back in 1714. Peter the Great created it as a collection of curiosities and scientific curiosities, and his heirs continued to replenish the collection. One of the very first exhibits of the Kunstkamera. The preparation with the skeleton of Siamese twins comes from the collection of the famous Dutch anatomist Frederic Ruysch.",
                    "St. Petersburg, Universitetskaya embankment, 3",
                    "59.941546","30.304499", "m138");

            /*127*/Insert_To_Museums("Zoo museum","The oldest zoological museum in Russia. The museum was formed in 1832 by separation from the Kunstkamera exposition.",
                    "St. Petersburg, Universitetskaya embankment, 1",
                    "59.942653","30.305942", "m139");

            /*128*/Insert_To_Museums("State Museum of Political History","Kshesinsky mansion. The mansion was built on the orders of Emperor Nicholas 2 for his favorite prima ballerina of the Mariinsky Theater Matilda Kshesinskaya. Now here is a rather complex, tangled history of our country is told in a very intelligible and interesting way. The museum can be called interactive, a lot of things you can click, listen to, look through.",
                    "St. Petersburg, Kuibysheva street, 2-4",
                    "59.954607","30.324752", "m140");

            /*129*/Insert_To_Museums("Erarta","Modern Art Museum",
                    "St. Petersburg, 29th line of Vasilyevsky Island, 2",
                    "59.932172","30.251511", "m141");

            /*130*/Insert_To_Museums("Museum of Art of St. Petersburg XX-XXI centuries","The Museum of Art of St. Petersburg of the XX-XXI centuries (MISP) is a repository of a unique collection, representing the pearl of the fine arts of the city on the Neva. Currently, the collection has 3906 items. storage. It covers the entire history of the development of art in Petrograd-Leningrad-St. Petersburg, from the avant-garde of the 1920s, socialist realism of the post-war period, the search for the \"left\" wing of the Union of Artists and the underground of the 1960s-1970s. to the artistic phenomena of perestroika and post-perestroika times, including today's trends.",
                    "St. Petersburg, Griboyedov Canal Embankment, 103",
                    "59.926491","30.300042", "m142");

            /*131*/Insert_To_Museums("Museum of the Academy of Arts","Claims to be the oldest art museum in Russia. Soon after the founding of the Imperial Academy of Arts in 1757, its founder I. I. Shuvalov transferred to the institution, then located in the chambers of his palace on Malaya Sadovaya, his own collection of paintings and drawings, which included works by Veronese and Rembrandt. During the XVIII-XIX centuries. the museum collection was replenished by other nobles, Catherine II and her successors on the Russian throne.",
                    "St. Petersburg, Universitetskaya embankment, 17",
                    "59.937385","30.290372", "m143");

            /*132*/Insert_To_Museums("Art Cafe Stray Dog","Legendary place in the city. Literary and artistic cabaret, one of the centers of the cultural life of the Silver Age. The glory of the art basement was made up of its visitors: Anna Akhmatova, Osip Mandelstam, Nikolai Gumilyov, Igor Severyanin, Nadezhda Teffi, Vladimir Mayakovsky, Velimir Khlebnikov, Vsevolod Meyerhold, Mikhail Kuzmin, Arthur Lurie, Konstantin Balmont, Tamara Karsavina, Alexei Tolstoy, Arkady Averchenko, Sergei Sudeikin, Nikolai Sapunov, Nikolai Kulbin, Nikolai Evreinov, Rurik Ivnev, Pallada Bogdanova-Belskaya, Dmitry Tyomkin, Alexei Lozina-Lozinsky and others.",
                    "St. Petersburg, Italian street, 4",
                    "59.937091","30.329190", "m145");

            /*133*/Insert_To_Museums("Museum of Optics","This is a fascinating and visual story about the magical properties of light, opening the veil to the world of optical illusions and actual lighting solutions.",
                    "St. Petersburg, Birzhevaya line, 14",
                    "59.944187","30.295536", "m147");

            /*134*/Insert_To_Museums("Museum-Apartment Kuindzhi","The famous Russian landscape painter Arkhip Ivanovich Kuindzhi spent the last 13 years of his life in this house. An office and a living room are open for visitors to the museum-apartment. The artist's studio currently has an exposition dedicated to the pedagogical activity of Arkhip Ivanovich Kuindzhi at the Academy of Arts, where from 1894 to 1897 he was a professor of landscape painting and directed the workshop.",
                    "St. Petersburg, Makarova embankment, 10",
                    "59.945225","30.294187", "m148");

            /*135*/Insert_To_Museums("Geological Exploration Museum","It is the largest in Russia and one of the largest natural history museums in the world. The museum's collection has more than a million items. The exposition presents over 80 thousand samples of minerals, rocks, ores, fossil fauna and flora. The highlight of the collection is the map of the USSR, made of stones and minerals!",
                    "St. Petersburg, Sredniy avenue of Vasilievsky island, 74",
                    "59.938188","30.262321", "m150");

            /*136*/Insert_To_Museums("Electric Transport Museum","The basis of the collection is the copies of the main models of trams and trolleybuses that are on the move, which were widely used in St. Petersburg, the operation of which was discontinued.",
                    "St. Petersburg, Sredniy avenue of Vasilievsky Island, 77",
                    "59.938962","30.260725", "m151");
//
            /*137*/Insert_To_Museums("\"Demutov tavern\"","Now the house on the Moika River, the back side of the Variety Theater. A. I. Raikin, is not particularly different from the neighboring ones - a typical St. Petersburg \"old fund\". And during the time of Alexander Sergeevich, it housed a well-known hotel - colloquially \"Demuth Tavern\" (named after the owner of the Strasbourg merchant Philipp-Jacob Demuth). In this place, which became in its own way a cult among the St. Petersburg intelligentsia of the 19th century, Alexander Pushkin stopped more than once. For the first time - in 1811, when he came with his uncle to St. Petersburg to enter the Lyceum. Then, as the researchers say, during his life he rented rooms more than once in the Demutov Tavern - he met with like-minded friends, he wrote. By the way, a description of a typical room of this hotel can be found in his poem \"Eugene Onegin\".",
                    "St. Petersburg, embankment of the Moika River, 40",
                    "59.937097","30.320492", "m152");

            /*138*/Insert_To_Museums("College of Foreign Affairs","After graduating from the Lyceum with the rank of collegiate secretary, it was in the Collegium of Foreign Affairs (MFA in modern times) that the young Alexander Pushkin entered the service. \"Company\" he was made up of his classmates - Wilhelm Kuchelbecker, Nikolai Korsakov, Alexander Gorchakov. And although the diplomatic service of Alexander Sergeevich did not appeal, he served in the Collegium from 1817 to 1824. The knowledge gained in the course of the work allowed him to evaluate the history of Russia in his own way and write in 1822 \"Notes on Russian history of the XIII century.\" Now the building of the former College of Foreign Affairs can be seen almost in its original form - its facade was restored according to the drawings of Quarenghi himself.",
                    "St. Petersburg, Galernaya street, 31",
                    "59.933641","30.292798", "m153");

            /*139*/Insert_To_Museums("\"House in Kolomna\"","Kolomna in St. Petersburg was called the outskirts of the city, which was located between the Fontanka and Moika rivers. Here, in a house built at the end of the 18th century and owned by Vice Admiral Fedot Alekseevich Klokachev, the Pushkin family, after graduating from Alexander Lyceum, rented a seven-room apartment on the third floor. As the memorial plaque, which is now located on the building, says, the poet lived here from 1817 to 1820. Researchers of his life and work found out that Alexander Pushkin lived in a small room, the windows of which overlooked the courtyard, where a small garden was laid out. It was during this period that he created the ode \"Liberty\", completed the poem \"Ruslan and Lyudmila\". Over time, the building, of course, was rebuilt more than once, and now it doesn’t look much like the one in which Alexander Sergeevich lived with his parents.",
                    "St. Petersburg, Fontanka river embankment, house 185",
                    "59.916607","30.287236", "m154");

            /*140*/Insert_To_Museums("Reindeer House","In the mansion owned by the Olenin spouses (Elizaveta Markovna, nee Poltoratskaya, daughter of the head of the Court Singing Chapel, and Alexei Nikolaevich, president of the Academy of Arts, director of the Public Library), at the beginning of the 19th century, the whole light of the literary and artistic life of St. Petersburg gathered. Alexander Sergeevich Pushkin was also a frequent guest here. So, it was in the literary salon of the Olenins that he read his poem \"Ruslan and Lyudmila\". In addition, Pushkin was seriously fascinated by the younger Olenina - Anna. And even proposed to her, but was refused. Here, earlier, the poet met another of his muse - 19-year-old niece of Elizabeth Markovna Anna Kern. Today there is a functioning hotel.",
                    "St. Petersburg, Fontanka river embankment, 101",
                    "59.923536","30.321185", "m155");

            /*141*/Insert_To_Museums("House of Princess Golitsyna E. N.","Another cult place in St. Petersburg of the early 19th century is the salon of Princess Evdokia (Avdotya) Golitsyna. According to legend, it was predicted that she would die at night. Allegedly, therefore, fearing death, she slept during the day. Having received the nickname of the \"night princess\", Evdokia Golitsyna gathered an elected society in her house late in the evening, and sometimes at midnight. Among her guests was often the young Alexander Sergeevich (since the autumn of 1817). According to the memoirs of contemporaries, despite the significant age difference, he was in love with her and dedicated several poems to her. Among them - \"The edges of strangers inexperienced lover\" and \"A simple pupil of nature.\" Alas, the famous mansion of the princess has not been preserved in its original form to this day.",
                    "St. Petersburg, Millionnaya street, 30",
                    "59.941732","30.319744", "m156");

            /*142*/Insert_To_Museums("Brieskorn O.K. House","Alexander Pushkin lived in this house for only a few months, but he called them the happiest in his life. After all, it was here that his first St. Petersburg apartment was located, in which he moved with his young wife, Natalia Goncharova. During a short stay (from the autumn of 1831 to the spring of 1832), the small tragedies “Mozart and Salieri” and “A Feast during the Plague” saw the light of day here, preparations were underway for the publication of the almanac “Northern Flowers for 1832”. Since 1934, there has been a memorial plaque on the house, and in our time, savvy entrepreneurs have opened the atmospheric boutique hotel Happy Pushkin here.",
                    "St. Petersburg, Galernaya street, 53",
                    "59.932023","30.288305", "m157");

            /*143*/Insert_To_Museums("Confectionery Wolf and Beranger","In the early 19th century, this establishment, located in the house of Kotin, was a very fashionable place. Here, not only delicious desserts were served, but also a kind of literary club, which Alexander Sergeevich also liked to attend. However, the confectionery is famous, primarily for the fact that it was in it that the poet was waiting for his second Konstantin Danzas before the fatal duel with Baron Dantes. The house has survived to this day. Now it houses the Literary Cafe restaurant, which honors the traditions of bygone times and the memory of the great poet, holds creative evenings and even made the portrait of Alexander Sergeevich its emblem.",
                    "St. Petersburg, Nevsky prospect, 18",
                    "59.936407","30.318996", "m158");

            /*144*/Insert_To_Museums("Monument to Pushkin A.S.","The figure of Pushkin is located on a pedestal and will be raised to a height of 7 m 90 cm. Alexander Sergeevich is embodied in bronze, the pedestal is made of granite. The front side of the pedestal is decorated with an inscription in gold letters: \"To Alexander Sergeevich Pushkin.\" Looking at the monument, one gets the impression that the poet is reading his immortal creations: his right arm is thrown back, his head is proudly thrown back and his coat is wide open. The monument turned out the way it was conceived by Mikhail Konstantinovich Anikushin, who wanted to show Pushkin as romantic, free, spiritual.",
                    "St. Petersburg, Arts Square",
                    "59.937251","30.331695", "m159");




            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }

    }


//    public void Drop_Mus(){
//
//        db.execSQL("DROP TABLE IF EXISTS " + DBHelper.TABLE_MUSEUMS);
//    }
    public void Delete_Mus(){

        db.delete(DBHelper.TABLE_MUSEUMS, null, null);
    }

    public void Delete_Res(){

        db.delete(DBHelper.TABLE_RESTAURANTS_BARS, null, null);
    }


}
