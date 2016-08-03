package com.ddb.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import com.ddb.beans.Note;
import com.ddb.beans.UserMessages;
/* mongoDB related imports start */
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
/* mongoDB related imports end */
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;


/* 
 To access the "NoteService" sayXMLHello()function use the URL-->
 http://localhost:8080/bignotes/rest/note   
 
 
  To access the "NoteService" SaveNote()function use the URL-->
  http://localhost:8080/bignotes/rest/savenote
 */

@Path("/note")
public class NoteService {
	
	MongoClient mongoClient;
	DB db;
	DBCollection coll;
	DBCursor cursor;

	
  
  @Path("/savenote")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)  
  @Produces(MediaType.APPLICATION_JSON) 
	public UserMessages saveNewNote(Note data)
			throws IOException {

	  System.out.println("Reached @POST Method !!WOW!! "); 
	  System.out.println("============================ "); 
	  System.out.println(data);
	  System.out.println("============================ "); 

		boolean success = saveNoteData(data);
		UserMessages userMsg = new UserMessages();
		if (success) {			 
			  userMsg.setMessage("Note successfully saved in Mongo DB");
			 
		} else {
			 userMsg.setMessage("Failed to insert Note in Mongo DB");
		}
		 return userMsg;
	}

	private boolean saveNoteData(Note data)
			throws UnknownHostException {
		connectToMongoDB();

		DBObject dbObject = (DBObject) JSON.parse(data.toString());

		WriteResult result = coll.insert(dbObject);
		System.out.println(result);

		return true;
	}
   
  
  
	
  @Path("/getNotes")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public ArrayList<Note> sayXMLHello() throws java.net.UnknownHostException{  
	connectToMongoDB();
	ArrayList<Note> aar= getNotesFromMongoDB();
	return aar;
	
  }

  public void connectToMongoDB() throws java.net.UnknownHostException{
	  /*
	  Making a Connection
		To make a connection to a MongoDB, you need to have at the minimum, the name of a database to connect to. The database doesn’t have to exist -if it doesn’t, MongoDB will create it for you
	  */
	  mongoClient = new MongoClient( "localhost" , 27017 );
	  db = mongoClient.getDB( "kuttidb" );
	  /*Getting a Collection
		To get a collection to use, just specify the name of the collection to the getCollection(String collectionName) method.
		Once you have this collection object, you can now do things like insert data, query for data, etc
	  */
	  coll = db.getCollection("notes");
	  cursor = coll.find();
	  
	  
  }
	
  public ArrayList<Note> getNotesFromMongoDB() {
	DBObject dbObj;
	ArrayList<Note> arrNotes = new ArrayList<Note>();
	
	try {
		while(cursor.hasNext()) {
			//System.out.println(cursor.next());
			dbObj = cursor.next();
			Note note2 = new Note();
			note2.setTitle(dbObj.get("title").toString());
			note2.setContents(dbObj.get("contents").toString());
			arrNotes.add(note2);
		}
	} finally {
		cursor.close();
	}
	
		return arrNotes;
  }
  
} 