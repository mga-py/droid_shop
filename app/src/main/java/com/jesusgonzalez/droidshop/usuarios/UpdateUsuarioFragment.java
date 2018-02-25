package com.jesusgonzalez.droidshop.usuarios;

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
 * {@link UpdateUsuarioFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UpdateUsuarioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdateUsuarioFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    EditText etCodigoClienteUpdate;
    EditText etNifUpdate;
    EditText etNombreUpdate;
    EditText etRolUpdate;
    EditText etActivoUpdate;

    Button button;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public UpdateUsuarioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UpdateUsuarioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UpdateUsuarioFragment newInstance(String param1, String param2) {
        UpdateUsuarioFragment fragment = new UpdateUsuarioFragment();
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
        View view = inflater.inflate(R.layout.fragment_update_usuario, container, false);

        etCodigoClienteUpdate = view.findViewById(R.id.et_codigoCliente_update);
        etNifUpdate = view.findViewById(R.id.et_nif_update);
        etNombreUpdate = view.findViewById(R.id.et_nombre_update);
        etRolUpdate = view.findViewById(R.id.et_rol_update);
        etActivoUpdate = view.findViewById(R.id.et_activoUsuario_update);

        button = view.findViewById(R.id.bt_updateUsuario);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUsuario(view);
                clear();
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

    public void updateUsuario(View view) {
        UsuarioController usuarioController = new UsuarioController(getContext(), view);
        usuarioController.update(
                String.valueOf(etNifUpdate.getText()),
                String.valueOf(etNombreUpdate.getText()),
                String.valueOf(etRolUpdate.getText()),
                String.valueOf(etActivoUpdate.getText()),
                String.valueOf(etCodigoClienteUpdate.getText()));
    }

    private void clear() {
        etCodigoClienteUpdate.setText("");
        etNifUpdate.setText("");
        etNombreUpdate.setText("");
        etRolUpdate.setText("");
        etActivoUpdate.setText("");
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
