package com.example.image;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LoadImageUtils {

    private static ArrayList<FolderImage> listFolder;

    //run in background thread
    public static List<FolderImage> loadImageFolder(Context context,String defaultCategory) {
        listFolder = new ArrayList<>();
        try {
            Uri uri;
            Cursor cursor;
            int columnData, columnFolder;

            String path;
            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

            final String orderBy = MediaStore.Images.Media.DATE_TAKEN;
            cursor = context.getContentResolver().query(uri, null, null, null, orderBy + " DESC");

            int colId = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns._ID);
            columnData = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            columnFolder = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);

            while (cursor.moveToNext()) {
                int mediaId = cursor.getInt(colId);
                path = cursor.getString(columnData);
                if (!new File(path).exists()) {
                    continue;
                }

                int position = findFolderIndex(listFolder, cursor, columnFolder);

                ArrayList<Media> mediaList = new ArrayList<>();
                Photo media = new Photo(path);
                media.setMediaId(mediaId);
                mediaList.add(media);

                if (position >= 0) {
                    mediaList.addAll(listFolder.get(position).getMediaList());
                    listFolder.get(position).setMediaList(mediaList);
                } else {
                    FolderImage objModel = new FolderImage();
                    objModel.setFolderName(cursor.getString(columnFolder));
                    objModel.setMediaList(mediaList);
                    listFolder.add(objModel);
                }

            }
            FolderImage folderAllImage = new FolderImage();
            folderAllImage.setFolderName(defaultCategory);
            folderAllImage.setMediaList(getMedialList(listFolder));
            listFolder.add(0, folderAllImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listFolder;
    }

    private static List<Media> getMedialList(ArrayList<FolderImage> listFolder) {
        List<Media> list = new ArrayList<>();
        for (int i = 0; i < listFolder.size(); i++) {
            list.addAll(listFolder.get(i).getMediaList());
        }
        return list;
    }

    private static int findFolderIndex(ArrayList<FolderImage> listFolder, Cursor cursor, int columnFolder) {
        for (int i = 0; i < listFolder.size(); i++) {
            if (listFolder.get(i).getFolderName() == null || cursor.getString(columnFolder) == null)
                continue;
            if (listFolder.get(i).getFolderName().equals(cursor.getString(columnFolder))) {
                return i;
            }
        }
        return -1;
    }
}
