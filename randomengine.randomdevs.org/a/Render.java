class Render {
  public void renderer(){
    long frame = 0;
    long skippedFrames = 0;
    long time = System.currentTimeMillis();
    while (true){
        long now = System.currentTimeMillis();
        double delta = (1000.0 / frame);
        long nextFrameAt = (long) (time + (frame + skippedFrames + 1) * delta);
        if (now >= nextFrameAt){
            System.out.println("Prossimo frame");
            int lag = (int) (now - nextFrameAt);
            if (lag > 0){
                int missedFrames = (int) (lag / delta);
                if (missedFrames > 0){
                    System.out.println("Frame mancato: " + missedFrames);
                    skippedFrames += missedFrames;
                }
            }
            frame++;
        }
        else{ //Sleppo, ci sta tempo restante per il prossimo frame
            int timeLeft = (int) (nextFrameAt - now);
            int marigin = 5;// Margine per evitare oversleep
            int sleepTime = timeLeft - marigin;
            if (sleepTime > 0){
                System.out.println("Sleeppare: " + sleepTime);
                Thread.sleep(sleepTime);
            }
        }
    }
  }
}
