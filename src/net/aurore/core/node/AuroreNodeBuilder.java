package net.aurore.core.node;

import javax.security.auth.login.LoginException;

import com.neovisionaries.ws.client.WebSocketFactory;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.managers.impl.PresenceImpl;
import net.dv8tion.jda.core.utils.ProvidingSessionController;
import net.dv8tion.jda.core.utils.SessionControllerAdapter;
import okhttp3.OkHttpClient;

public class AuroreNodeBuilder extends JDABuilder{
	
	public AuroreNodeBuilder(AccountType accountType) {
		super(accountType);
	}
	
	public JDA buildAsync() throws LoginException {
		OkHttpClient.Builder httpClientBuilder = this.httpClientBuilder == null ? new OkHttpClient.Builder()
				: this.httpClientBuilder;
		WebSocketFactory wsFactory = this.wsFactory == null ? new WebSocketFactory() : this.wsFactory;

		if (controller == null) {
			if (reconnectQueue != null || shardRateLimiter != null)
				controller = new ProvidingSessionController(reconnectQueue, shardRateLimiter);
			else if (shardInfo != null)
				controller = new SessionControllerAdapter();
		}
		AuroreNode jda = new AuroreNode(accountType, token, controller, httpClientBuilder, wsFactory, autoReconnect,
				enableVoice, enableShutdownHook, enableBulkDeleteSplitting, requestTimeoutRetry, enableContext,
				corePoolSize, maxReconnectDelay, contextMap);

		if (eventManager != null)
			jda.setEventManager(eventManager);

		if (audioSendFactory != null)
			jda.setAudioSendFactory(audioSendFactory);

		listeners.forEach(jda::addEventListener);
		jda.setStatus(JDA.Status.INITIALIZED); 

		String gateway = jda.getGateway();


		((PresenceImpl) jda.getPresence()).setCacheGame(game).setCacheIdle(idle).setCacheStatus(status);
		jda.login(gateway, shardInfo);
		
		return jda;
	}
}
