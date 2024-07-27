package org.users;

import java.time.Year;
import java.util.*;

public class Membership {
    int memberFrom;
    int memberId; //unique id generated while joining library
    Users user;
    Map<Integer, Membership> membershipUsers = new HashMap<Integer, Membership>();

    public Membership(Users user) {
        this.memberFrom = Year.now().getValue();
        this.user = user;
    }
    public Membership(){}
    public int addMember(Users user) {
        this.memberId = new Random().nextInt(1000) + 1; //Math.floor(Math.random() * 1000) + 1;
        membershipUsers.put(this.memberId, new Membership(user));
        return 1;
    }

    public Membership getMember(String name){
        for(Membership member : membershipUsers.values()){
            if(member.getUser().getName().equalsIgnoreCase(name)){
                return member;
            }
        }
        return null;
    }

    public Users updateUser(String name, Users newDetails){
        Membership member = getMember(name);
        if(member != null){
            member.user = newDetails;
            membershipUsers.put(member.memberId, member);
            return newDetails;
        }
        return null;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Users getUser() {
        return user;
    }
}
