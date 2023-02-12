package com.ae_chat.aechatapi.websocket;

public class SocketRequestType {
    // GROUP
    static final String SOCKET_REQUEST_CREATE_GROUP = "create_group";
    static final String SOCKET_REQUEST_UPDATE_GROUP = "update_group";
    static final String SOCKET_REQUEST_MUTE_GROUP = "mute_group";
    static final String SOCKET_REQUEST_UN_MUTE_GROUP = "unmute_group";
    static final String SOCKET_REQUEST_PIN_GROUP = "pin_group";
    static final String SOCKET_REQUEST_UN_PIN_GROUP = "unpin_group";
    static final String SOCKET_REQUEST_LEAVE_GROUP = "leave_group";
    static final String SOCKET_REQUEST_DELETE_GROUP = "delete_group";
    static final String SOCKET_REQUEST_LIST_GROUP = "list_group";
    static final String SOCKET_REQUEST_CHECK_GROUP = "check_group";

    // MESSAGE
    static final String SOCKET_REQUEST_DELETE_CONVERSATION = "delete_conversation";
    static final String SOCKET_REQUEST_CREATE_MESSAGE = "create_message";
    static final String SOCKET_REQUEST_UPDATE_MESSAGE = "update_message";
    static final String SOCKET_REQUEST_LIST_MESSAGE = "list_message";
    static final String SOCKET_REQUEST_DELETE_MESSAGE = "delete_message";
    static final String SOCKET_REQUEST_REACTION_MESSAGE = "reaction_message";
    static final String SOCKET_REQUEST_LIST_REACTION_MESSAGE = "list_reaction_message";
}
