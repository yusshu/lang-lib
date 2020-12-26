package me.yushust.message.test;

import me.yushust.message.MessageHandler;
import me.yushust.message.test.base.Entity;
import me.yushust.message.test.base.HandlerTestCase;
import org.junit.jupiter.api.Test;

public class JitEntitiesFormattingTest extends HandlerTestCase {

  @Test
  public void test() {

    MessageHandler<Entity> handler = MessageHandler.builder(Entity.class)
        .setRepository(repository)
        .addExternalProvider("ent", NamedEntity.class, (ctx, entity, param) -> entity.name)
        .build();

    Entity entity = new Entity();
    NamedEntity namedEntity = new NamedEntity();
    namedEntity.name = "OcNo";

    System.out.println(handler.getMany(entity, "jit-entity-test", namedEntity));

    NamedEntity namedEntity2 = new NamedEntity();
    namedEntity2.name = "Fixed";

    System.out.println(handler.getMany(entity, "jit-entity-test", namedEntity2));

  }

  private static class NamedEntity {
    private String name;
  }

}