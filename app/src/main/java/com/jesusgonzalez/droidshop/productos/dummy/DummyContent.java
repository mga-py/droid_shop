package com.jesusgonzalez.droidshop.productos.dummy;

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
////        }
//        addlistDumyItem();
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static void addlistDumyItem(List list) {
        for (int i = 0; i < list.size(); i++) {
            DummyItem dummyItemTemp = (DummyItem) list.get(i);
            addItem(dummyItemTemp);
        }


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
//        public final String id;
//        public final String content;
//        public final String details;
//
//        public DummyItem(String id, String content, String details) {
//            this.id = id;
//            this.content = content;
//            this.details = details;
//        }

//        public DummyItem(String id, String content, String details) {
//            this.id = id;
//            this.content = content;
//            this.details = details;
//        }

        //Atributos
        public final String id;
        public final String codigoProducto;
        public final String descripcion;
        public final String idProveedor;
        public final String precioCoste;
        public final String iva;
        public final String codigoBarras;
        public final String stockActual;
        public final String stockMinimo;
        public final String stockMaximo;
        public final String rutaFoto;
        public final String activo;


        public DummyItem(String id, String codigoProducto, String descripcion, String idProveedor, String precioCoste, String iva, String codigoBarras, String stockActual, String stockMinimo, String stockMaximo, String rutaFoto, String activo) {
            this.id = id;
            this.codigoProducto = codigoProducto;
            this.descripcion = descripcion;
            this.idProveedor = idProveedor;
            this.precioCoste = precioCoste;
            this.iva = iva;
            this.codigoBarras = codigoBarras;
            this.stockActual = stockActual;
            this.stockMinimo = stockMinimo;
            this.stockMaximo = stockMaximo;
            this.rutaFoto = rutaFoto;
            this.activo = activo;
        }


        @Override
        public String toString() {
            return "DummyItem{" +
                    "codigoProducto='" + codigoProducto + '\'' +
                    ", descripcion='" + descripcion + '\'' +
                    ", idProveedor='" + idProveedor + '\'' +
                    ", precioCoste='" + precioCoste + '\'' +
                    ", iva='" + iva + '\'' +
                    ", codigoBarras='" + codigoBarras + '\'' +
                    ", stockActual='" + stockActual + '\'' +
                    ", stockMinimo='" + stockMinimo + '\'' +
                    ", stockMaximo='" + stockMaximo + '\'' +
                    ", rutaFoto='" + rutaFoto + '\'' +
                    ", activo='" + activo + '\'' +
                    '}';
        }
    }
}
