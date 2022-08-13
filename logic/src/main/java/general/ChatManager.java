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
        List<Chat> chatList1= chatDataList.stream().filter(chat -> chat.getUserId() == from && chat.getChatId() == to)
                .collect(Collectors.toList());
        List<Chat> chatList2= chatDataList.stream().filter(chat -> chat.getChatId() == from && chat.getUserId() == to)
                .collect(Collectors.toList());
        chatList1.addAll(chatList2);
        return chatList1;
    }

    public int getVersion() {
        return chatDataList.size();
    }

}

