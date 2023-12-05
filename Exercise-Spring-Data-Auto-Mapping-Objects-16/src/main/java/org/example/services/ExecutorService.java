package org.example.services;

public interface ExecutorService {
    String REGISTER_USER_COMMAND = "RegisterUser";
    String LOGIN_USER_COMMAND = "LoginUser";
    String LOGOUT_USER_COMMAND = "Logout";
    String ADD_GAME_COMMAND = "AddGame";
    String EDIT_GAME_COMMAND = "EditGame";
    String DELETE_GAME_COMMAND = "DeleteGame";
    String ALL_GAMES = "AllGames";
    String DETAIL_GAME = "DetailGame";
    String OWNED_GAMES = "OwnedGames";
    String ADD_ITEM = "AddItem";
    String REMOVE_ITEM = "RemoveItem";
    String BUY_ITEM = "BuyItem";

    String execute(String command);
}
