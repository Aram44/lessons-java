package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class UserRepository {

    private final Map<UUID, User> users;
    private final Map<UUID, Integer> userDiscount;

    public UserRepository() {
        this.users = new HashMap<>();
        this.userDiscount = new HashMap<>();
    }

    public Optional<User> findUserById(UUID useId) {
        return Optional.ofNullable(users.get(useId));
    }

    public void addUser(User user) {
        if (users.get(user.getId()) != null) {
            throw new RuntimeException();
        }
        this.users.putIfAbsent(user.getId(), user);
    }

    public void addDiscount(UUID userId, int percent) {
        if (percent <= 0 || percent > 100) {
            throw new RuntimeException("wring.percent.value");
        }
        this.userDiscount.put(userId, percent);
    }

    public Optional<Integer> getUserDiscount(UUID userId) {
        return Optional.ofNullable(userDiscount.get(userId));
    }
}
