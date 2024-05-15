package estu.ceng.menumapper2.helper;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

public class DoubleArrayCodec implements Codec<double[]> {

    @Override
    public void encode(BsonWriter writer, double[] value, EncoderContext encoderContext) {
        writer.writeStartArray();
        for (double v : value) {
            writer.writeDouble(v);
        }
        writer.writeEndArray();
    }

    @Override
    public double[] decode(BsonReader reader, DecoderContext decoderContext) {
        reader.readStartArray();
        java.util.List<Double> values = new java.util.ArrayList<>();
        while (reader.readBsonType() != org.bson.BsonType.END_OF_DOCUMENT) {
            values.add(reader.readDouble());
        }
        reader.readEndArray();
        double[] array = new double[values.size()];
        for (int i = 0; i < values.size(); i++) {
            array[i] = values.get(i);
        }
        return array;
    }

    @Override
    public Class<double[]> getEncoderClass() {
        return double[].class;
    }
}
