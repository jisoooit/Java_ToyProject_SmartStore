package me.java.project.menu;

import me.java.project.customer.Customer;
import me.java.project.customer.Customers;
import me.java.project.exception.ErrorMessage;
import me.java.project.exception.InputRangeException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerMenu extends Menu{
    private static CustomerMenu customerMenu;
    private String[] menus = {"Set Customer Data", "View Customer Data"," Update Customer Data", "Delete Customer Data","Back"};
    private String [] methods = {"setCusData", "viewCusData","updateCusData","deleteCusData"};

    private Customers allCustomers = Customers.getInstance();
    Pattern pattern = Pattern.compile("^[a-zA-Z]{3,}$");
    Pattern patternId = Pattern.compile("^[a-zA-Z][a-zA-Z0-9_]{5,12}$");

    Matcher matcher;

    private CustomerMenu() {};

    public static CustomerMenu getInstance(){
        if ( customerMenu == null ){
            customerMenu = new CustomerMenu();
        }
        return customerMenu;
    }


    public void setCusData() {

        while (true) {
            try  {
                System.out.println("** Press -1, if you want to exit! **");
                System.out.print("How many customers to input? ");

                int addCnt = Integer.parseInt(scanner.next());

                if (addCnt == -1) {
                    break;
                }

                for (int i = 0; i < addCnt; i++) {
                    String userName = null;
                    String userId = null;
                    int spentTime = 0;
                    int totalPay = 0;

                    System.out.println("=====Customer Info" + (i + 1) + "=====");
                    while (true) {
                        try {
                            System.out.println("===============================");
                            System.out.println("1. Customer Name");
                            System.out.println("2. Customer ID");
                            System.out.println("3. Customer Spent Time");
                            System.out.println("4. Customer Total Pay");
                            System.out.println("5. Back");
                            System.out.println("===============================");


                            System.out.print("Choose One: ");
                            int InfoSelect = Integer.parseInt(scanner.next());
                            if (InfoSelect < 1 || InfoSelect > 5) {
                                throw new InputRangeException();
                            }

                            if (InfoSelect == 5) {
                                Customer newCustomer = new Customer(userName, userId, spentTime, totalPay);
                                allCustomers.customerAdd(newCustomer);
                                break;
                            } else if (InfoSelect == 1) {

                                do {
                                    System.out.print("Input Customer's Name: ");
                                    userName = scanner.next();
                                    matcher = pattern.matcher(userName);
                                } while (!matcher.find());


                            } else if (InfoSelect == 2) {

                                do {
                                    System.out.print("Input Customer's UserID: ");
                                    userId = scanner.next();
                                    matcher = patternId.matcher(userId);
                                } while (!matcher.find());

                            } else if (InfoSelect == 3) {
                                System.out.print("Input Customer's Spent Time at Your Store: ");
                                spentTime =Integer.parseInt(scanner.next());
                            } else if (InfoSelect == 4) {
                                System.out.print("Input Customer's Total Payment at Your Store");
                                totalPay = Integer.parseInt(scanner.next());
                            }
                    }
                        catch (NumberFormatException e ){
                            System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_FORMAT);
                        }  catch (InputRangeException e){
                            System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_RANGE);
                        }
                }
                }
            }catch (NumberFormatException e ){
                System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_FORMAT);
            }
        }
    }
    public void viewCusData() {
        System.out.println("=====Customer Info=====");

        allCustomers.showCustomers();
    }
    public void updateCusData() {
        String updateUserName=null;
        String updateUserId=null;
        int updateSpentTime=0;
        int updateTotalPay=0;
        int updateNo;
        allCustomers.showCustomers();

       while (true){

           try{
               int end = allCustomers.getSize();
               System.out.println("Which Customer (" + 1 + "~" + end + ")? ");
               if (end <= 0) {
                   System.out.println("업데이트 할 손님이 없습니다.");
                   return;
               }


               updateNo = Integer.parseInt(scanner.next());
               if (updateNo < 1 || updateNo > end) {
                   throw new InputRangeException();
               } else {
                   break;
               }

           } catch (NumberFormatException e){
               System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_FORMAT);
           }
           catch (InputRangeException e){
               System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_RANGE);
           }
       }

        while (true) {
            try {
                System.out.println("===============================");
                System.out.println("1. Customer Name");
                System.out.println("2. Customer ID");
                System.out.println("3. Customer Spent Time");
                System.out.println("4. Customer Total Pay");
                System.out.println("5. Back");
                System.out.println("===============================");


                System.out.print("Choose One: ");
                int InfoSelect =  Integer.parseInt(scanner.next());
                if (InfoSelect < 1 || InfoSelect > 5) {
                    throw new InputRangeException();
                }

                if (InfoSelect == 5) {
                    allCustomers.customerUpdate(updateNo, updateUserName, updateUserId, updateSpentTime, updateTotalPay);
                    break;
                } else if (InfoSelect == 1) {
                    do {
                        System.out.print("Input Customer's Name: ");
                        updateUserName = scanner.next();
                        matcher = pattern.matcher(updateUserName);
                    } while (!matcher.find());

                } else if (InfoSelect == 2) {
                    do {
                        System.out.print("Input Customer's UserID: ");
                        updateUserId = scanner.next();
                        matcher = patternId.matcher(updateUserId);
                    } while (!matcher.find());

                } else if (InfoSelect == 3) {
                    System.out.print("Input Customer's Spent Time at Your Store: ");
                    updateSpentTime = Integer.parseInt(scanner.next());

                } else if (InfoSelect == 4) {
                    System.out.print("Input Customer's Total Payment at Your Store:  ");
                    updateTotalPay = Integer.parseInt(scanner.next());

                }
            } catch (NumberFormatException e){
                System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_FORMAT);
            }
            catch (InputRangeException e){
                System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_RANGE);
            }
        }

    }

    public void deleteCusData() {
        allCustomers.showCustomers();
        while(true){
            try {
                int end = allCustomers.getSize();
                System.out.println("Which Customer (" + 1 + "~" + end + ")? ");

                if (end <= 0) {
                    System.out.println("업데이트 할 손님이 없습니다.");
                    return;
                }

                int deleteNo = Integer.parseInt(scanner.next());
                if (deleteNo < 1 || deleteNo > end) {
                    throw new InputRangeException();
                }
                allCustomers.customerDelete(deleteNo);
                break;
            } catch (NumberFormatException e){
                System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_FORMAT);
            } catch (InputRangeException e){
                System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_RANGE);
            }
        }


    }

    @Override
    public void manage() {
        setInstance(customerMenu);
        setMethods(methods);
        super.manage();
    }

    @Override
    public int dispMenu() {
        setMenus(menus);
        return super.dispMenu();
    }
}
