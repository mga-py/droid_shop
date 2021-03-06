package com.jesusgonzalez.droidshop.productos;

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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddProductoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddProductoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddProductoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    EditText etCodigoProductoAdd;
    EditText etDescripcionProductoAdd;
    EditText etProveedorProductoAdd;
    EditText etPrecioCosteProductoAdd;
    EditText etPvpProductoAdd;
    EditText etIvaProductoAdd;
    EditText etActivoProductoAdd;


    Button button;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AddProductoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddProductoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddProductoFragment newInstance(String param1, String param2) {
        AddProductoFragment fragment = new AddProductoFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_producto, container, false);


        etCodigoProductoAdd = view.findViewById(R.id.et_codigoProducto_add);
        etDescripcionProductoAdd = view.findViewById(R.id.et_descripcion_add);
        etProveedorProductoAdd = view.findViewById(R.id.et_proveedor_add);
        etPrecioCosteProductoAdd = view.findViewById(R.id.et_precioCoste_add);
        etPvpProductoAdd = view.findViewById(R.id.et_pvp_add);
        etIvaProductoAdd = view.findViewById(R.id.et_iva_add);
        etActivoProductoAdd = view.findViewById(R.id.et_activoProducto_add);


        button = view.findViewById(R.id.bt_addProducto);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarProducto(v);
                clear();
            }
        });


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }


    }


    public void insertarProducto(View view) {
        ProductoController productoController = new ProductoController(getContext(), view);
        productoController.insert(String.valueOf(etCodigoProductoAdd.getText().toString()), String.valueOf(etDescripcionProductoAdd.getText()),
                String.valueOf(etProveedorProductoAdd.getText().toString()), String.valueOf(etPrecioCosteProductoAdd.getText().toString()), String.valueOf(etPvpProductoAdd.getText()),
                String.valueOf(etIvaProductoAdd.getText()), "123456", "20", "10", "50", "", "1");
    }

    private void clear() {
        etCodigoProductoAdd.setText("");
        etDescripcionProductoAdd.setText("");
        etProveedorProductoAdd.setText("");
        etPrecioCosteProductoAdd.setText("");
        etPvpProductoAdd.setText("");
        etIvaProductoAdd.setText("");
        etActivoProductoAdd.setText("");
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
