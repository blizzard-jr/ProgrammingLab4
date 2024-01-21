package mumiytroll;

import java.util.ArrayList;

public interface Main_characters {
    void setGeneralMood(TrollsEmotion stat);
    void callEveryone(ArrayList<Friend> fr);
    TrollsEmotion getGeneralMood();



}
