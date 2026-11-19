/*Challenge 6: Inheritance + Composition — “Game Characters”
Goal: Combine inheritance hierarchy with composition-based abilities.
Instructions:
• Base: Character
• Derived:
o Wizard
o Warrior
• Class (composition): Weapon, Spell, etc.
Task:
Characters should inherit core behaviors but contain (not inherit) items/abilities.
 */
public class Lab6CH6 {
    public static void main(String[] args) {
        Weapon sword = new Weapon("Excalibur", 50);
        Spell fireball = new Spell("Fireball", 30);

        Warrior warrior = new Warrior("Aragorn", sword);
        Wizard wizard = new Wizard("Gandalf", fireball);

        System.out.println(warrior.getName() + " attacks with " + warrior.getWeapon().getName() + " dealing " + warrior.getWeapon().getDamage() + " damage.");
        System.out.println(wizard.getName() + " casts " + wizard.getSpell().getName() + " dealing " + wizard.getSpell().getDamage() + " damage.");
    }
    public static abstract class Character {
        private String name;

        public Character(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
    public static class Warrior extends Character {
        private Weapon weapon;

        public Warrior(String name, Weapon weapon) {
            super(name);
            this.weapon = weapon;
        }

        public Weapon getWeapon() {
            return weapon;
        }
    }
    public static class Wizard extends Character {
        private Spell spell;

        public Wizard(String name, Spell spell) {
            super(name);
            this.spell = spell;
        }

        public Spell getSpell() {
            return spell;
        }
    }
    public static class Weapon {
        private String name;
        private int damage;

        public Weapon(String name, int damage) {
            this.name = name;
            this.damage = damage;
        }

        public String getName() {
            return name;
        }

        public int getDamage() {
            return damage;
        }
    }
    public static class Spell {
        private String name;
        private int damage;

        public Spell(String name, int damage) {
            this.name = name;
            this.damage = damage;
        }

        public String getName() {
            return name;
        }

        public int getDamage() {
            return damage;
        }
    }
    
}
