package br.com.atrasado.data.network.api.parser;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by caue.ferreira on 6/24/16.
 */

public class DateTimeTypeAdapter implements JsonDeserializer<Date> {
    public DateTimeTypeAdapter() {
    }

    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss.SSSZ");

        try {
            return parser.parse(json.getAsString().replace("Z", ""));
        } catch (ParseException var7) {
            parser = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss");

            try {
                return parser.parse(json.getAsString().replace("Z", ""));
            } catch (ParseException var6) {
                return null;
            }
        }
    }
}