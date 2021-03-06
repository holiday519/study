package com.ee.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AioTimeServerHandler> {

	@Override
	public void completed(AsynchronousSocketChannel result, AioTimeServerHandler attachment) {
		attachment.asynchronousServerSocketChannel.<AioTimeServerHandler>accept(attachment, this);
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		result.read(buffer, buffer, new ReadCompletionHandler(result));
	}

	@Override
	public void failed(Throwable exc, AioTimeServerHandler attachment) {
		exc.printStackTrace();
		attachment.latch.countDown();
	}

}
