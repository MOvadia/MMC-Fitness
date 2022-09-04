package general;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ChatManager {
    private final List<Chat> chatDataList;

    public ChatManager() {
        chatDataList = new ArrayList<>();
    }

    public synchronized void addChatString(String chatString, int from, int to) {
        List<Chat> chatList = getChatEntries(from, to);
        int size = chatList.size();
        chatDataList.add(new Chat(chatString, from, to, size+1));
    }

    /*public synchronized List<Chat> getChatEntries(int fromIndex){
        if (fromIndex < 0 || fromIndex > chatDataList.size()) {
            fromIndex = 0;
        }
        return chatDataList.subList(fromIndex, chatDataList.size());
    }*/

    public synchronized List<Chat> getChatEntries(int from, int to){
        //TODO: check
        List<Chat> chatList1= new ArrayList<>();
        List<Chat> chatListFixed= new ArrayList<>();
        chatList1.addAll(chatDataList.stream().filter(chat -> chat.getUserId() == from && chat.getChatId() == to)
                .collect(Collectors.toList()));
        List<Chat> chatList2= chatDataList.stream().filter(chat -> chat.getChatId() == from && chat.getUserId() == to)
                .collect(Collectors.toList());
        chatList1.addAll(chatList2);
        String type = UserManager.getTypeById(to);
        String nameTo = UserManager.getUserNameById(to);

        for (Chat chat: chatList1) {
            Chat chatElement;
            if(chat.getContent() == "")
            {
                chatElement = new Chat(chat.getContent(), from, to, chat.getMessageNum());
                chatElement.setTitle("Chat with " + type + " (" + nameTo + ")");

            }
            else {
                if (chat.getUserId() == from) {
                    chatElement = new Chat("Me: " + chat.getContent(), from, to, chat.getMessageNum());
                } else {
                    chatElement = new Chat(type + ": " + chat.getContent(), to, from, chat.getMessageNum());
                }
            }

            chatListFixed.add(chatElement);
        }
        //return chatListFixed;
         chatListFixed.sort(Comparator.comparing(o -> o.getMessageNum()));
        return chatListFixed;
    }

    public int getVersion() {
        return chatDataList.size();
    }

}

