package com.jesusgonzalez.droidshop.pedidos.dummy;

import java.util.ArrayList;
import java.util.Date;
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
        public final String id;
        public final String codigoPedido;
        public final String idEmpleadoEmpaqueta;
        public final String empresaTransporte;
        public final String fechaPedido;
        public final String fechaEnvio;
        public final String fechaEnrega;
        public final String fechaPago;
        public final String idFactura;
        public final String facturado;
        public final String metodoPago;
        public final String activo;
        public final String idUsuario;

        public DummyItem(String id, String codigoPedido, String idEmpleadoEmpaqueta, String empresaTransporte, String fechaPedido, String fechaEnvio, String fechaEnrega, String fechaPago, String idFactura, String facturado, String metodoPago, String activo, String idUsuario) {
            this.id = id;
            this.codigoPedido = codigoPedido;
            this.idEmpleadoEmpaqueta = idEmpleadoEmpaqueta;
            this.empresaTransporte = empresaTransporte;
            this.fechaPedido = fechaPedido;
            this.fechaEnvio = fechaEnvio;
            this.fechaEnrega = fechaEnrega;
            this.fechaPago = fechaPago;
            this.idFactura = idFactura;
            this.facturado = facturado;
            this.metodoPago = metodoPago;
            this.activo = activo;
            this.idUsuario = idUsuario;
        }

        @Override
        public String toString() {
            return "DummyItem{" +
                    "id='" + id + '\'' +
                    ", codigoPedido='" + codigoPedido + '\'' +
                    ", idEmpleadoEmpaqueta='" + idEmpleadoEmpaqueta + '\'' +
                    ", empresaTransporte='" + empresaTransporte + '\'' +
                    ", fechaPedido='" + fechaPedido + '\'' +
                    ", fechaEnvio='" + fechaEnvio + '\'' +
                    ", fechaEnrega='" + fechaEnrega + '\'' +
                    ", fechaPago='" + fechaPago + '\'' +
                    ", idFactura='" + idFactura + '\'' +
                    ", facturado='" + facturado + '\'' +
                    ", metodoPago='" + metodoPago + '\'' +
                    ", activo='" + activo + '\'' +
                    ", idUsuario='" + idUsuario + '\'' +
                    '}';
        }
    }
}
