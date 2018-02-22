package com.jesusgonzalez.droidshop.usuarios.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
//        for (int i = 1; i <= COUNT; i++) {
//            addItem(createDummyItem(i));
//        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

//    private static DummyItem createDummyItem(int position) {
//        return new DummyItem(String.valueOf(position), "Item " + position, makeDetails(position));
//    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        //Atributos
        public final String id;
        public final String codigoCliente;
        public final String nif;
        public final String nombre;
        public final String apellido1;
        public final String apellido2;
        public final String numeroCuenta;
        public final String rol;
        public final boolean activo;

        //Constructores


        public DummyItem(String id, String codigoCliente, String nif, String nombre, String apellido1, String apellido2, String numeroCuenta, String rol, boolean activo) {
            this.id = id;
            this.codigoCliente = codigoCliente;
            this.nif = nif;
            this.nombre = nombre;
            this.apellido1 = apellido1;
            this.apellido2 = apellido2;
            this.numeroCuenta = numeroCuenta;
            this.rol = rol;
            this.activo = activo;
        }


        @Override
        public String toString() {
            return "DummyItem{" +
                    "id=" + id +
                    ", codigoCliente='" + codigoCliente + '\'' +
                    ", nif='" + nif + '\'' +
                    ", nombre='" + nombre + '\'' +
                    ", apellido1='" + apellido1 + '\'' +
                    ", apellido2='" + apellido2 + '\'' +
                    ", numeroCuenta='" + numeroCuenta + '\'' +
                    ", rol='" + rol + '\'' +
                    ", activo=" + activo +
                    '}';
        }
    }
}
