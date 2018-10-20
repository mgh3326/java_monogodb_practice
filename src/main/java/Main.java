import com.mongodb.MongoClient;

import com.mongodb.client.*;
import org.bson.Document;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World");

        MongoClient mongoClient = new MongoClient("localhost", 27017);
//        logger.info("MongoClient connected");

        MongoDatabase db = mongoClient.getDatabase("test");
//        logger.info("Get 'namu' MongoDatabase");
        System.out.println("데이터 베이스명: " + db.getName());
        MongoCollection<Document> collections = db.getCollection("test");

        FindIterable<Document> iterate = collections.find();
        MongoCursor<Document> cursor = iterate.iterator();

        while (cursor.hasNext()) {
            Document document = cursor.next();
            String JsonResult = document.toJson();
            System.out.println(JsonResult);
        }
//        logger.info("Get 'namudb' Document");


    }
}
