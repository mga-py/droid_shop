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
 * {@link UpdateProductoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UpdateProductoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdateProductoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    EditText etCodigoProductoUpdate;
    EditText etDescripcionProductoUpdate;
    EditText etProveedorProductoUpdate;
    EditText etPrecioCosteProductoUpdate;
    EditText etPvpProductoUpdate;
    EditText etIvaProductoUpdate;
    EditText etActivoProductoUpdate;


    Button button;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public UpdateProductoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UpdateProductoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UpdateProductoFragment newInstance(String param1, String param2) {
        UpdateProductoFragment fragment = new UpdateProductoFragment();
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
        View view = inflater.inflate(R.layout.fragment_update_producto, container, false);


        etCodigoProductoUpdate = view.findViewById(R.id.et_codigoProducto_update);
        etDescripcionProductoUpdate = view.findViewById(R.id.et_descripcion_update);
        etProveedorProductoUpdate = view.findViewById(R.id.et_proveedor_update);
        etPrecioCosteProductoUpdate = view.findViewById(R.id.et_precioCoste_update);
        etPvpProductoUpdate = view.findViewById(R.id.et_pvp_update);
        etIvaProductoUpdate = view.findViewById(R.id.et_iva_update);
        etActivoProductoUpdate = view.findViewById(R.id.et_activoProducto_update);
        button = view.findViewById(R.id.bt_updateProducto);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modificarProducto(view);
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


    public void modificarProducto(View view) {
        ProductoController productoController = new ProductoController(getContext(), view);
        productoController.update(String.valueOf(etDescripcionProductoUpdate.getText()),
                String.valueOf(etProveedorProductoUpdate.getText().toString()), String.valueOf(etPrecioCosteProductoUpdate.getText().toString()), String.valueOf(etPvpProductoUpdate.getText()),
                String.valueOf(etIvaProductoUpdate.getText()), String.valueOf(etActivoProductoUpdate.getText()), String.valueOf(etCodigoProductoUpdate.getText().toString()));
    }

    private void clear() {
        etCodigoProductoUpdate.setText("");
        etDescripcionProductoUpdate.setText("");
        etProveedorProductoUpdate.setText("");
        etPrecioCosteProductoUpdate.setText("");
        etPvpProductoUpdate.setText("");
        etIvaProductoUpdate.setText("");
        etActivoProductoUpdate.setText("");
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
