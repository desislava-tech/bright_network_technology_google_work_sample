package com.google;

import java.util.*;
import java.lang.*;
import java.util.Random;

public class VideoPlayer {

  private final VideoLibrary videoLibrary;
  ArrayList<String> previousId = new ArrayList<String>();
  private boolean paused = false;
  private Video playingVid;

  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
    // print as: title (video_id) [tags]
    List<Video> videoList = videoLibrary.getVideos();
    videoList.sort(Comparator.comparing(Video::getTitle));

    System.out.println("Here's a list of all available videos:");
    for (int i = 0 ; i < videoList.size() ; i++){
      System.out.println(videoList.get(i).getTitle() + " (" + videoList.get(i).getVideoId() + ") " + String.valueOf(videoList.get(i).getTags()).replaceAll(",", ""));
    }
  }

  public void playVideo(String videoId) {

    Video video = videoLibrary.getVideo(videoId);
    try {
      if (video != null) {
        if (previousId.size() == 0) {
          previousId.add(videoLibrary.getVideo(videoId).getTitle());
        } else {
          System.out.println("Stopping video: " + previousId.get(0));
          previousId.remove(0);
          previousId.add(videoLibrary.getVideo(videoId).getTitle());
        }
        System.out.println("Playing video: " + videoLibrary.getVideo(videoId).getTitle());
        playingVid = video;
      }
      else
        System.out.println("Cannot play video: Video does not exist");
    }
    catch (NullPointerException npe){
      System.out.println("Cannot play video: Video does not exist");
    }
  }

  public void stopVideo() {
    if (previousId.size() == 0)
      System.out.println("Cannot stop video: No video is currently playing");
    else {
      System.out.println("Stopping video: " + previousId.get(0));
      previousId.remove(0);
      playingVid = null;
    }
  }

  public void playRandomVideo() {
    Random rand = new Random();
    List<Video> videoList = videoLibrary.getVideos();
    //String randomVid = videoList.get(rand.nextInt(videoList.size())).getTitle();
    Video video = videoList.get(rand.nextInt(videoList.size()));
    String randomVid = video.getTitle();

    if (previousId.size() == 0){
      previousId.add(randomVid);
    }
    else{
      System.out.println("Stopping video: " + previousId.get(0));
      previousId.remove(0);
    }
    System.out.println("Playing video: " + randomVid);
    playingVid = video;
  }

  public void pauseVideo() {
    if (previousId.size() == 0)
      System.out.println("Cannot pause video: No video is currently playing");
    else{
      if (paused){
        System.out.println("Video already paused: " + previousId.get(0));
      }
      else{
        System.out.println("Pausing video: " + previousId.get(0));
        paused = true;
      }
    }

  }

  public void continueVideo() {
    System.out.println("continueVideo needs implementation");
  }

  public void showPlaying() {
    System.out.println("showPlaying needs implementation");
  }

  public void createPlaylist(String playlistName) {
    System.out.println("createPlaylist needs implementation");
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    System.out.println("addVideoToPlaylist needs implementation");
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}