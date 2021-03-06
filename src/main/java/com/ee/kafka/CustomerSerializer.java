//package com.ee.kafka;
//
//import java.nio.ByteBuffer;
//import java.util.Map;
//
//import org.apache.commons.lang3.SerializationException;
//import org.apache.kafka.common.serialization.Serializer;
//
//public class CustomerSerializer implements Serializer<Customer> {
//
//	@Override
//	public void configure(Map<String, ?> configs, boolean isKey) {
//
//	}
//
//	@Override
//	public byte[] serialize(String topic, Customer data) {
//		try {
//			if (data == null) {
//				return null;
//			} else {
//				byte[] serializedName;
//				int stringSize;
//				if (data.getName() != null) {
//					serializedName = data.getName().getBytes("UTF-8");
//					stringSize = serializedName.length;
//				} else {
//					serializedName = new byte[0];
//					stringSize = 0;
//				}
//				ByteBuffer buffer = ByteBuffer.allocate(4 + 4 + stringSize);
//				buffer.putInt(data.getID());
//				buffer.putInt(stringSize);
//				buffer.put(serializedName);
//				return buffer.array();
//			}
//		} catch (Exception e) {
//			throw new SerializationException("Error when serializing Customer to byte[] " + e);
//		}
//
//	}
//
//	@Override
//	public void close() {
//
//	}
//
//}
