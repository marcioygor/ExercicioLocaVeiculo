package com.example.marcioygor.locaveiculo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcio Ygor on 28/04/2018.
 */

public class DataH extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Banco.db";

    // Usuário
    private static final String TABELA_Veiculo = "veiculo";

    private static final String COLUNA_VEICULO_ID = "veiculo_id";
    private static final String COLUNA_VEICULO_VEICULO = "veiculo";
    private static final String COLUNA_VEICULO_ANO = "ano";
    private static final String COLUNA_VEICULO_COR = "cor";
    private static final String COLUNA_VEICULO_KM= "KM";



    private String CREATE_VEICULO_TABLE = "CREATE TABLE " + TABELA_Veiculo
            + "(" + COLUNA_VEICULO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUNA_VEICULO_VEICULO + " TEXT,"
            + COLUNA_VEICULO_ANO + " TEXT,"
            + COLUNA_VEICULO_COR+ " TEXT,"
            + COLUNA_VEICULO_KM + " TEXT"
            +")";


    private String DROP_VEICULO_TABLE = "DROP TABLE IF EXISTS " + TABELA_Veiculo;

    public DataH(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DROP_VEICULO_TABLE);
        db.execSQL(CREATE_VEICULO_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_VEICULO_TABLE);
        onCreate(db);
    }

    public void CadastrarVeiculo(Veiculo veiculo) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUNA_VEICULO_VEICULO, veiculo.getVeiculo());
        values.put(COLUNA_VEICULO_ANO, veiculo.getAno());
        values.put(COLUNA_VEICULO_COR, veiculo.getCor());
        values.put(COLUNA_VEICULO_KM, veiculo.getKM());

        db.insert(TABELA_Veiculo, null, values);
        db.close();
    }


    public List<Veiculo> ListarVeiculo() {
        String[] columns = {
                COLUNA_VEICULO_ID,
                COLUNA_VEICULO_VEICULO,
                COLUNA_VEICULO_COR,
                COLUNA_VEICULO_KM,
                COLUNA_VEICULO_ANO,
        };

        String sortOrder = COLUNA_VEICULO_VEICULO + " ASC";
        List<Veiculo> VeiculoList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABELA_Veiculo,
                columns,
                null,
                null,
                null,
                null,
                sortOrder);

        if (cursor.moveToFirst()) {
            do {
                Veiculo veiculo = new Veiculo();
                veiculo.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUNA_VEICULO_ID))));
                veiculo.setVeiculo(cursor.getString(cursor.getColumnIndex(COLUNA_VEICULO_VEICULO)));
                veiculo.setCor(cursor.getString(cursor.getColumnIndex(COLUNA_VEICULO_COR)));
                veiculo.setAno(cursor.getString(cursor.getColumnIndex(COLUNA_VEICULO_ANO)));
                veiculo.setKM(cursor.getString(cursor.getColumnIndex(COLUNA_VEICULO_KM)));

                VeiculoList.add(veiculo);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return VeiculoList;
    }
}
