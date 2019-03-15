package appmoviles.com.appsmoviles20191.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import appmoviles.com.appsmoviles20191.model.Amigo;

public class DBHandler extends SQLiteOpenHelper{

    private static DBHandler instance=null;

    public static final String DB_NAME="AppMoviles20191";
    public static final int DB_VERSION=1;
    
    //----------------------------------------------
    //Tabla AMIGOS
    //----------------------------------------------
    public static final String TABLE_AMIGOS="amigos";
    public static final String AMIGOS_ID="id";
    public static final String AMIGOS_NOMBRE="edad";
    public static final String AMIGOS_EDAD="edad";
    public static final String AMIGOS_CORREO="correo";
    public static final String AMIGOS_TELEFONO="telefono";
    
    //-----------------------------------------------
    //SQL
    //-----------------------------------------------
    public static final String CREATE_TABLE_AMIGOS="CREATE TABLE "+TABLE_AMIGOS+" ("+AMIGOS_ID+" TEXT PRIMARY KEY, "+AMIGOS_NOMBRE+" TEXT, "+AMIGOS_EDAD+" TEXT, "+AMIGOS_CORREO+" TEXT, "+AMIGOS_TELEFONO+" TEXT)";

    public static synchronized DBHandler getInstance(Context contex){
        if(instance==null){
            instance = new DBHandler(contex);
        }
        return  instance;
    }

    private DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_AMIGOS);
    }

    //Se hace cuando aumentamos la version de la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_AMIGOS);
        onCreate(db);
    }

    //-----------------------------------------
    //CRUD
    //-----------------------------------------

    //CREATE
    public void createAmigo(Amigo amigo){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO "+TABLE_AMIGOS+" ("+AMIGOS_ID+","+AMIGOS_NOMBRE+","+AMIGOS_EDAD+","+AMIGOS_CORREO+","+AMIGOS_TELEFONO+") VALUES ('"+amigo.getId()+"','"+amigo.getNombre()+"','"+amigo.getEdad()+"','"+amigo.getCorreo()+"','"+amigo.getTelefono()+"')");
        db.close();
    }
    //READ
    public ArrayList<Amigo> getAllAmigos(){
        ArrayList<Amigo> respuesta = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_AMIGOS,null);
        if(cursor!=null && cursor.moveToFirst()){
            do{
                Amigo amigo = new Amigo();
                amigo.setId(cursor.getString(cursor.getColumnIndex(AMIGOS_ID)));
                amigo.setNombre(cursor.getString(cursor.getColumnIndex(AMIGOS_NOMBRE)));
                amigo.setEdad(cursor.getString(cursor.getColumnIndex(AMIGOS_EDAD)));
                amigo.setCorreo(cursor.getString(cursor.getColumnIndex(AMIGOS_CORREO)));
                amigo.setTelefono(cursor.getString(cursor.getColumnIndex(AMIGOS_TELEFONO)));
                respuesta.add(amigo);
            }while(cursor.moveToNext());
        }
        db.close();
        return respuesta;
    }
}
