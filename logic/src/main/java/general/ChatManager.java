package general;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChatManager {
    private final List<Chat> chatDataList;

    public ChatManager() {
        chatDataList = new ArrayList<>();
    }

    public synchronized void addChatString(String chatString, int from, int to) {
        chatDataList.add(new Chat(chatString, from, to));
    }

    /*public synchronized List<Chat> getChatEntries(int fromIndex){
        if (fromIndex < 0 || fromIndex > chatDataList.size()) {
            fromIndex = 0;
        }
        return chatDataList.subList(fromIndex, chatDataList.size());
    }*/

    public synchronized List<Chat> getChatEntries(int from, int to){
        //TODO: check
        List<Chat> chatList= chatDataList.stream().filter(chat -> chat.getUserId() == from || chat.getUserId() == to)
                .collect(Collectors.toList());
        chatList= chatList.stream().filter(chat -> chat.getTo() == from || chat.getTo()==to).collect(Collectors.toList());
        //return chatDataList.subList(fromIndex, chatDataList.size());
        return chatList;
    }

    public int getVersion() {
        return chatDataList.size();
    }

}

