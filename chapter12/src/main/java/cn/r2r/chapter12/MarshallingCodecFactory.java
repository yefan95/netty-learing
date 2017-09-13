package cn.r2r.chapter12;

import org.jboss.marshalling.*;

import java.io.IOException;

public class MarshallingCodecFactory {

    protected static Marshaller buildingMarshalling() throws IOException {
        final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");
        final MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
        Marshaller marshaller = marshallerFactory.createMarshaller(configuration);
        return marshaller;
    }

    protected static Unmarshaller buildingUnMarshalling() throws IOException {
        final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");
        final MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);
        Unmarshaller marshaller = marshallerFactory.createUnmarshaller(configuration);
        return marshaller;
    }

}
