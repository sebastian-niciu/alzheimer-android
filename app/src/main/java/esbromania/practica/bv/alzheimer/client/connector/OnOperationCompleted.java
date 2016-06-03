package esbromania.practica.bv.alzheimer.client.connector;

import esbromania.practica.bv.alzheimer.client.api.model.Greeting;

/**
 * @author Sebastian Niciu
 */
public interface OnOperationCompleted {

    void onGetResponse(Greeting greeting);

    void onGetResponse(String message);
}
