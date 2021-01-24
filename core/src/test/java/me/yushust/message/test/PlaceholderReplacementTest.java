package me.yushust.message.test;

import me.yushust.message.MessageProvider;
import me.yushust.message.test.base.Entity;
import me.yushust.message.test.base.HandlerTestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlaceholderReplacementTest extends HandlerTestCase {

  @Test
  public void test() {

    MessageProvider handler = MessageProvider.create(
        repository,
        wiring -> wiring
            .specify(Entity.class)
            .addProvider("obj", testProvider())
    );

    Entity entity = new Entity();
    Assertions.assertEquals("Your object hashcode is 0 and as string it's i'manentity",
        handler.get(entity, "replace-this"));

  }

}
