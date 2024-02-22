import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _9_Heroes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> heroHP = new LinkedHashMap<>();
        Map<String, Integer> heroMana = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String hero = scanner.nextLine();
            String[] arr = hero.split(" ");

            String heroName = arr[0];
            int hp = Integer.parseInt(arr[1]);
            int mana = Integer.parseInt(arr[2]);

            //"{hero name} {HP} {MP}"
            if(hp<=100&&mana<=200){
                heroHP.put(heroName,hp);
                heroMana.put(heroName,mana);
            }
        }

        String command = scanner.nextLine();
        //"CastSpell – {hero name} – {MP needed} – {spell name}"
        //"TakeDamage – {hero name} – {damage} – {attacker}"
        //"Recharge – {hero name} – {amount}"
        //"Heal – {hero name} – {amount}"
        while(!command.equals("End")){
            String[] arr = command.split(" - ");
            String mainCommand = arr[0];
            String heroName = arr[1];

            if(mainCommand.equals("CastSpell")){
                int mana = Integer.parseInt(arr[2]);
                String spell = arr[3];

                if(mana<=heroMana.get(heroName)){
                    heroMana.put(heroName, heroMana.get(heroName)-mana);
                    System.out.printf("%s has successfully cast %s and now has %d MP!%n",heroName,spell,heroMana.get(heroName));
                } else {
                    System.out.printf("%s does not have enough MP to cast %s!%n",heroName,spell);
                }
            }
            else if(mainCommand.equals("TakeDamage")){
                int damage = Integer.parseInt(arr[2]);
                String attacker = arr[3];
                if(heroHP.get(heroName)-damage<=0){
                    System.out.printf("%s has been killed by %s!%n",heroName,attacker);
                    heroHP.remove(heroName);
                    heroMana.remove(heroName);
                } else {//"{hero name} was hit for {damage} HP by {attacker} and now has {current HP} HP left!"
                    heroHP.put(heroName,heroHP.get(heroName)-damage);
                    System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",heroName,damage,attacker,heroHP.get(heroName));
                }
            }
            else if(mainCommand.equals("Recharge")){
                int amount = Integer.parseInt(arr[2]);
                int manaRegenerated;
                if(heroMana.get(heroName)+amount>200){
                    manaRegenerated = 200-heroMana.get(heroName);
                    heroMana.put(heroName,200);
                } else {
                    manaRegenerated=amount;
                    heroMana.put(heroName,heroMana.get(heroName)+amount) ;
                }
                System.out.printf("%s recharged for %d MP!%n",heroName,manaRegenerated);
            }
            else if(mainCommand.equals("Heal")){
                int amount = Integer.parseInt(arr[2]);
                int hpRegenerated;
                if(heroHP.get(heroName)+amount>100){
                    hpRegenerated = 100-heroHP.get(heroName);
                    heroHP.put(heroName,100);
                } else {
                    hpRegenerated = amount;
                    heroHP.put(heroName,heroHP.get(heroName)+amount);
                }
                System.out.printf("%s healed for %d HP!%n",heroName,hpRegenerated);
            }
            command = scanner.nextLine();
        }
        for (String hero: heroHP.keySet()) {
            System.out.println(hero);
            System.out.println("  HP: "+heroHP.get(hero));
            System.out.println("  MP: "+heroMana.get(hero));
        }
    }
}
