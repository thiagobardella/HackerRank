package hackerRank;


import java.util.*;

public class Friend {
    private Collection<Friend> friends;
    private String email;

    public Friend(String email) {
        this.email = email;
        this.friends = new ArrayList<Friend>();
    }

    public String getEmail() {
        return email;
    }

    public Collection<Friend> getFriends() {
        return friends;
    }

    public void addFriendship(Friend friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }

    public boolean canBeConnected(Friend friend) {
        if (friend.equals(this)) return true;

        Set<Friend> peopleVisited = new HashSet<>();

        peopleVisited.add(this);

        LinkedList<Friend> friendsToVisit = new LinkedList<>();
        friendsToVisit.add(this);

        while(!friendsToVisit.isEmpty()) {
            Friend friendToVisit = friendsToVisit.removeFirst();
            for (Friend friendOfFriend : friendToVisit.friends) {
                if (friendOfFriend.equals(friend)) return true;
                if (!peopleVisited.contains(friendOfFriend)) {
                    peopleVisited.add(friendOfFriend);
                    friendsToVisit.add(friendOfFriend);
                }
            }
        }
            //        }
//
//        if (this.friends.contains(friend)) return true;
//
//        for (Friend friend1 : friends) {
//            if (!friendsVisited.contains(friend1)) {
//                if (friend1.canBeConnected(friend)) return true;
//                else {
//                    friendsVisited.add(friend1);
//                }
//            }
//        }
        return false;
//        throw new UnsupportedOperationException("Waiting to be implemented.");
    }

//    public boolean canBeConnected(Friend friend) {
//        if (friend.equals(this)) return true;
//        Set<Friend> friendSet = new HashSet<>();
//        friendSet.add(this);
//        Deque<Friend> queue = new LinkedList<>();
//        queue.addLast(this);
//        while(!queue.isEmpty()) {
//            Friend first = queue.removeFirst();
//            if (first.friends != null) {
//                for(Friend neighbor: first.friends) {
//                    if (neighbor.equals(friend)) return true;
//                    if (!friendSet.contains(neighbor)) {
//                        friendSet.add(neighbor);
//                        queue.addLast(neighbor);
//                    }
//                }
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        Friend a = new Friend("A");
        Friend b = new Friend("B");
        Friend c = new Friend("C");

        a.addFriendship(c);
        a.addFriendship(b);
        b.addFriendship(a);
        b.addFriendship(c);

        System.out.println(c.canBeConnected(a));
    }
}