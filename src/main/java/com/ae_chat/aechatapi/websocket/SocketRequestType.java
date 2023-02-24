package com.ae_chat.aechatapi.websocket;

public class SocketRequestType {
    // GROUP
    public static final String SOCKET_REQUEST_CREATE_GROUP = "create_group";
    public static final String SOCKET_REQUEST_UPDATE_GROUP = "update_group";
    public static final String SOCKET_REQUEST_MUTE_GROUP = "mute_group";
    public static final String SOCKET_REQUEST_UN_MUTE_GROUP = "unmute_group";
    public static final String SOCKET_REQUEST_PIN_GROUP = "pin_group";
    public static final String SOCKET_REQUEST_UN_PIN_GROUP = "unpin_group";
    public static final String SOCKET_REQUEST_LEAVE_GROUP = "leave_group";
    public static final String SOCKET_REQUEST_DELETE_GROUP = "delete_group";
    public static final String SOCKET_REQUEST_LIST_GROUP = "list_group";
    public static final String SOCKET_REQUEST_CHECK_GROUP = "check_group";

    // MESSAGE
    public static final String SOCKET_REQUEST_DELETE_CONVERSATION = "delete_conversation";
    public static final String SOCKET_REQUEST_CREATE_MESSAGE = "create_message";
    public static final String SOCKET_REQUEST_UPDATE_MESSAGE = "update_message";
    public static final String SOCKET_REQUEST_LIST_MESSAGE = "list_message";
    public static final String SOCKET_REQUEST_DELETE_MESSAGE = "delete_message";
    public static final String SOCKET_REQUEST_REACTION_MESSAGE = "reaction_message";
    public static final String SOCKET_REQUEST_LIST_REACTION_MESSAGE = "list_reaction_message";
}
