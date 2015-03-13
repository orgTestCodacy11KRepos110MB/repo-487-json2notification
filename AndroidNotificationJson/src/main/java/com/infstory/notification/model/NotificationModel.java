package com.infstory.notification.model;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import com.infstory.notification.Utils;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONObject;

import java.util.List;

import proguard.annotation.Keep;
import proguard.annotation.KeepClassMembers;

@Keep
@KeepClassMembers
@JsonObject
public class NotificationModel implements ModelBuilder<Notification> {
    private static final String BIG_PICTURE_STYLE = "bigPictureStyle";
    private static final String CONTENT_INTENT = "contentIntent";
    private static final String DELETE_INTENT = "deleteIntent";

    @Keep
    @KeepClassMembers
    @JsonObject
    public static class BigPictureStyleModel {
        @JsonField
        public String bigLargeIcon;
        @JsonField
        public String bigPicture;
        @JsonField
        public String contentTitle;
        @JsonField
        public String summaryText;
    }

    @JsonField
    public Boolean autoCancel;
    @JsonField(name = BIG_PICTURE_STYLE)
    public BigPictureStyleModel bigPictureStyleModel;
    @JsonField
    public String category;
    @JsonField
    public Integer color;
    @JsonField
    public String contentInfo;
    @JsonField(name = CONTENT_INTENT)
    public PendingIntentModel contentIntentModel;
    @JsonField
    public String contentTitle;
    @JsonField
    public String contentText;
    @JsonField
    public Integer defaults;
    @JsonField(name = DELETE_INTENT)
    public PendingIntentModel deleteIntentModel;
//    @JsonField
//    public BundleModel extras;
    @JsonField
    public String groupKey;
    @JsonField
    public Boolean groupSummary;
    @JsonField
    public String largeIcon;
    @JsonField
    public List<Integer> lights;
    @JsonField
    public Boolean localOnly;
    @JsonField
    public Integer number;
    @JsonField
    public Boolean ongoing;
    @JsonField
    public Boolean onlyAlertOnce;
    @JsonField
    public List<String> people;
    @JsonField
    public Integer priority;
//    @JsonField
//    public Progress progress;
//    @JsonField
//    public Notification publicVersion;
    @JsonField
    public Boolean showWhen;
    @JsonField
    public String smallIcon;
    @JsonField
    public String sortKey;
//    @JsonField
//    public Sound sound;
    @JsonField
    public String subText;
    @JsonField
    public String tickerText;
    @JsonField
    public Boolean usesChronometer;
    @JsonField
    public Integer visibility;
    @JsonField
    public Long when;

    @Override
    public Notification build(Object... objects) {
        JSONObject jsonObject = (JSONObject) objects[0];
        Context context  = (Context) objects[1];

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

        if (!Utils.isEmpty(autoCancel)) {
            builder.setAutoCancel(autoCancel);
        }
        if (!Utils.isEmpty(category)) {
            builder.setCategory(category);
        }
        if (!Utils.isEmpty(contentTitle)) {
            builder.setContentTitle(contentTitle);
        }
        if (!Utils.isEmpty(color)) {
            builder.setColor(color);
        }
        if (!Utils.isEmpty(contentInfo)) {
            builder.setContentInfo(contentInfo);
        }
        if (!Utils.isEmpty(contentInfo)) {
            builder.setContentInfo(contentInfo);
        }
        if (!Utils.isEmpty(contentIntentModel)) {
            builder.setContentIntent(contentIntentModel.build(context));
        }
        if (!Utils.isEmpty(contentTitle)) {
            builder.setContentTitle(contentTitle);
        }
        if (!Utils.isEmpty(contentText)) {
            builder.setContentText(contentText);
        }
        if (!Utils.isEmpty(defaults)) {
            builder.setDefaults(defaults);
        }
        if (!Utils.isEmpty(deleteIntentModel)) {
            builder.setDeleteIntent(deleteIntentModel.build(context));
        }
//        if (!Utils.isEmpty(extras)) {
//            Bundle bundle = new Bundle();
//            for (String key : extras.keySet()) {
//                        bundle.putString(key, extras.get(key));
//            }
//            builder.setExtras(bundle);
//        }
        if (!Utils.isEmpty(groupKey)) {
            builder.setGroup(groupKey);
        }
        if (!Utils.isEmpty(groupSummary)) {
            builder.setGroupSummary(groupSummary);
        }
        if (!Utils.isEmpty(largeIcon)) {
            Bitmap largeIconBitmap = ImageLoader.getInstance().loadImageSync(largeIcon);
            if (largeIconBitmap != null) builder.setLargeIcon(largeIconBitmap);
        }
        if (!Utils.isEmpty(localOnly)) {
            builder.setLocalOnly(localOnly);
        }
        if (!Utils.isEmpty(number)) {
            builder.setNumber(number);
        }
        if (!Utils.isEmpty(ongoing)) {
            builder.setOngoing(ongoing);
        }
        if (!Utils.isEmpty(onlyAlertOnce)) {
            builder.setOnlyAlertOnce(onlyAlertOnce);
        }
        if (!Utils.isEmpty(priority)) {
            builder.setPriority(priority);
        }
//                if (!Utils.isEmpty(showWhen)) {
//                    builder.showWhen(showWhen);
//                }
        if (!Utils.isEmpty(smallIcon)) {
            Bitmap smallIconBitmap = ImageLoader.getInstance().loadImageSync(smallIcon);
            if (smallIconBitmap != null) builder.setSmallIcon(Utils.getDrawableId(
                    context, smallIcon));
        }
        if (!Utils.isEmpty(sortKey)) {
            builder.setSortKey(sortKey);
        }
        if (!Utils.isEmpty(subText)) {
            builder.setSubText(subText);
        }
        if (!Utils.isEmpty(tickerText)) {
            builder.setTicker(tickerText);
        }
        if (!Utils.isEmpty(usesChronometer)) {
            builder.setUsesChronometer(usesChronometer);
        }
        if (!Utils.isEmpty(visibility)) {
            builder.setVisibility(visibility);
        }
        if (!Utils.isEmpty(when)) {
            builder.setWhen(when);
        }

        NotificationCompat.Style style = null;

        if (!Utils.isEmpty(bigPictureStyleModel)) {
            NotificationCompat.BigPictureStyle bigPictureStyle
                    = new NotificationCompat.BigPictureStyle();
            if (!Utils.isEmpty(bigPictureStyleModel.bigLargeIcon)) {
                Bitmap bigLargeIcon = ImageLoader.getInstance().loadImageSync(
                        bigPictureStyleModel.bigLargeIcon);
                if (bigLargeIcon != null) bigPictureStyle.bigLargeIcon(bigLargeIcon);
            }
            if (!Utils.isEmpty(bigPictureStyleModel.bigPicture)) {
                Bitmap bigPicture = ImageLoader.getInstance().loadImageSync(
                        bigPictureStyleModel.bigPicture);
                if (bigPicture != null) bigPictureStyle.bigPicture(bigPicture);
            }
            if (!Utils.isEmpty(bigPictureStyleModel.contentTitle)) {
                bigPictureStyle.setBigContentTitle(
                        bigPictureStyleModel.contentTitle);
            }
            if (!Utils.isEmpty(bigPictureStyleModel.summaryText)) {
                bigPictureStyle.setSummaryText(
                        bigPictureStyleModel.summaryText);
            }
            style = bigPictureStyle;
        }

        if (style != null) builder.setStyle(style);

        return builder.build();
    }
}