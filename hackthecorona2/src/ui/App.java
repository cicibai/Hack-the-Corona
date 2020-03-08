package ui;


import model.HttpClient;
import model.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public Scanner input;
    HttpClient httpClient;
    public Store Walmart;
    public Store Superstore;
    public Store SDM;
    public Store SOF;
    public Store LD;
    public Store HD;
    public Store CT;
    public List<Store> doesContainTP;
    public List<Store> doesContainM;
    public List<Store> doesContainHS;
    public List<Store> allStores;
    public List<Store> availableStores;


    public App() {
        httpClient = new HttpClient();
        runApp();
    }


    public void runApp() {
        boolean keeprunning = true;
        while (keeprunning) {
            options();
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
            createStores();

            if (option == 1) {
                for (Store store: allStores) {
                    if (store.getcontainsMasks()) {
                        System.out.println(store.getName());
                        String storeName = store.getName();
                        addAddress(storeName);
                    }
                }
            } else if (option == 2) {
                for (Store store: allStores) {
                    if (store.getcontainsToiletPaper()) {
                        System.out.println(store.getName());
                        String storeName = store.getName();
                        addAddress(storeName);
                    }
                }
            } else if (option == 3) {
                for (Store store: allStores) {
                    if (store.getHandSanitizer()) {
                        System.out.println(store.getName());
                        String storeName = store.getName();
                        addAddress(storeName);
                    }
                }
            } else if (option == 4) {
                keeprunning = false;
            }
        }
    }


    public void addAddress(String address) {
        try {
            httpClient.placeSearch(address);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void options() {
        System.out.println("Which item would you like to find?");
        System.out.println("1. Face Masks");
        System.out.println("2. Toilet Paper");
        System.out.println("3. Hand Sanitizer");
        System.out.println("4. Quit");
    }

    public void createStores() {
        allStores = new ArrayList<Store>();
        Walmart = new Store("Walmart", true, true,true);
        Superstore = new Store("Superstore" , true, false, true);
        SDM = new Store("Shoppers Drug Mart", false,false, true);
        SOF = new Store("Save On Foods" , true, false, true);
        LD = new Store("London Drugs" , true, false, true);
        HD = new Store("Home Depot" , true, true, true);
        CT = new Store("Canadian Tire", true, true, true );
        allStores.add(Walmart);
        allStores.add(Superstore);
        allStores.add(SDM);
        allStores.add(SOF);
        allStores.add(LD);
        allStores.add(HD);
        allStores.add(CT);
    }

//    public void containsToiletPaper() {
//        for (Store store: allStores) {
//            if (store.getcontainsToiletPaper()) {
//                doesContainTP.add(store);
//            }
//        }
//    }
//
//    public void containsMasks() {
//        for (Store store: allStores) {
//            if (store.getcontainsMasks()) {
//                doesContainM.add(store);
//            }
//        }
//    }
//
//    public void getHandSanitizer() {
//        for (Store store: allStores) {
//            if (store.getHandSanitizer()) {
//                doesContainHS.add(store);
//            }
//        }
//    }

}