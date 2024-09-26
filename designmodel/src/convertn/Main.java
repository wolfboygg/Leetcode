package convertn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String value = "{\n" +
                "    \"id\":\"\",\n" +
                "    \"liveId\":\"\",\n" +
                "    \"currentTurnId\":\"\",\n" +
                "    \"status\":\"waiting|selecting-question|draw-guessing|answer-announcing|end\",\n" +
                "    \"currentDrawer\":\"\",\n" +
                "    \"latestWinner\":\"\",\n" +
                "    \"questionTips\":[\n" +
                "        \"\",\n" +
                "        \"\"\n" +
                "    ],\n" +
                "    \"countDownSeconds\":0\n" +
                "}";

        List<Integer> anims = new ArrayList();
        anims.add(3);
        anims.add(4);
        anims.add(5);
        System.out.println(anims.toString());
        if (anims.size() == 2) {
            anims.add(1, 200);
        } else if (anims.size() == 3) {
            anims.add(1, 200);
            anims.add(3, 200);
        }
        System.out.println(anims.toString());
        System.out.println(Long.MIN_VALUE);
    }
}
