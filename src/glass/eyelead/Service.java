package glass.eyelead;

import com.google.android.glass.app.Card;
import com.google.android.glass.timeline.LiveCard;
import com.google.android.glass.timeline.TimelineManager;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RemoteViews;

/**
 * TODO: document your custom view class.
 */
public class Service {
	
	// Cached instance of the LiveCard created by the publishCard() method.
	private LiveCard mLiveCard;
	Coords coord;


	private void publishCard(Context context){
	    if (mLiveCard == null) {
	        String cardId = "my_card";
	        TimelineManager tm = TimelineManager.from(context);
	        mLiveCard = tm.createLiveCard(cardId);
	        
	        RemoteViews estilo = new RemoteViews(context.getPackageName(),
		             R.layout.card);
	        estilo.setImageViewBitmap(R.id.foto, coord.getFoto());
	        estilo.setTextViewText(R.id.nombre, coord.getinfo()[0]);
	        estilo.setTextViewText(R.id.info, coord.getinfo()[1]);
	        
	        mLiveCard.setViews(estilo);
	        Intent intent = new Intent(context, MenuActivity.class);
	        mLiveCard.setAction(PendingIntent.getActivity(context, 0,
	                intent, 0));
	        mLiveCard.publish(LiveCard.PublishMode.REVEAL); //Reveal Lleva al usuario a la LiveCard
	    } else {
	        // Card is already published.
	        return;
	    }
	}

	private void unpublishCard(Context context) {
	    if (mLiveCard != null) {
	        mLiveCard.unpublish();
	        mLiveCard = null;
	    }
	}
	
}
