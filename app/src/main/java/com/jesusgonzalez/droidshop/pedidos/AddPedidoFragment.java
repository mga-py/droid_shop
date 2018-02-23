package com.jesusgonzalez.droidshop.pedidos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.jesusgonzalez.droidshop.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddPedidoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddPedidoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddPedidoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    EditText etCodigoPedido;
    EditText etEmpleado;
    EditText etEmpresaTransporte;
    EditText etFechaPedido;
    EditText etIdFactura;
    EditText etFacturado;
    EditText etMetodoPago;
    EditText etIdUsuario;
    EditText etActivo;
    Button button;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AddPedidoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddPedidoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddPedidoFragment newInstance(String param1, String param2) {
        AddPedidoFragment fragment = new AddPedidoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_pedido, container, false);

        etCodigoPedido = view.findViewById(R.id.et_codigoPedido_add);
        etEmpleado = view.findViewById(R.id.et_empleado_add);
        etEmpresaTransporte = view.findViewById(R.id.et_empresaTransporte_add);
        etFechaPedido = view.findViewById(R.id.et_fechaPedido_add);
        etIdFactura = view.findViewById(R.id.et_idFactura_add);
        etFacturado = view.findViewById(R.id.et_facturado_add);
        etMetodoPago = view.findViewById(R.id.et_metodoPago_add);
        etIdUsuario = view.findViewById(R.id.et_idUsuario_add);
        etActivo = view.findViewById(R.id.et_activoPedido_add);


        button = view.findViewById(R.id.bt_addPedido);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPedido(view);
            }
        });


        // Inflate the layout for this fragment
        return view;
    }


    public void addPedido(View view) {
        PedidoController pedidoController = new PedidoController(getContext(), view);

        //SimpleDateFormat formatea = new SimpleDateFormat("yyyy-MM-dd");

        pedidoController.insert(etCodigoPedido.getText().toString(),
                String.valueOf(etEmpleado.getText().toString()),
                String.valueOf(etEmpresaTransporte.getText().toString()),
                String.valueOf(etFechaPedido.getText().toString()),
                String.valueOf(etFechaPedido.getText().toString()),
                String.valueOf(etFechaPedido.getText().toString()),
                String.valueOf(etFechaPedido.getText().toString()),
                String.valueOf(etIdFactura.getText().toString()),
                String.valueOf(etFacturado.getText().toString()),
                String.valueOf(etMetodoPago.getText().toString()),
                String.valueOf(etIdUsuario.getText().toString()),
                String.valueOf(etActivo.getText().toString()));

    }




    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
