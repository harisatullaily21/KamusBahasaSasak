package com.example.kamusbahasasasak.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

public class Kamus {

    public static final String KATA_KERJA = "KATA_KERJA";
    public static final String KATA_BENDA = "KATA_BENDA";
    public static final String KATA_SIFAT = "KATA_SIFAT";

    private String id;
    private String kata;
    private String arti;
    private String jenis;
    private String contoh;

    public Kamus() { this.id = UUID.randomUUID().toString();}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKata() {
        return kata;
    }

    public void setKata(String kata) {
        this.kata = kata;
    }

    public String getArti() {
        return arti;
    }

    public void setArti(String arti) {
        this.arti = arti;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getContoh() {
        return contoh;
    }

    public void setContoh(String contoh) {
        this.contoh = contoh;
    }

    public static Kamus fromJSONObject(JSONObject obj) {
        Kamus tr = new Kamus();
        try {
            tr.setId(obj.getString("id"));
            tr.setKata(obj.getString("kata"));
            tr.setArti(obj.getString("arti"));
            tr.setJenis(obj.getString("jenis"));
            tr.setContoh(obj.getString("contoh"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tr;
    }

    public JSONObject toJSONObject() {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("id", this.id);
            jsonObj.put("kata", this.kata);
            jsonObj.put("arti", this.arti);
            jsonObj.put("jenis", this.jenis);
            jsonObj.put("contoh", this.contoh);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObj;
    }
}

