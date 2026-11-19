package dnd;

public class Main {

    public static void main(String[] args) {
        Guerrero Thorin = new Guerrero("Thorin", 14);
        Mago Artanas = new Mago("Artanas");
        Sala dungeon = new Sala();

        try {
            dungeon.entrar(Thorin);
        } catch (TrampaException te) {
            int danio = te.getDanio();
            // aca deberia poner que el guerrero recibe danio
        } catch (PuertaCerradaException pe) {
            System.out.println(pe.getCause());
            System.out.println("Necesitas la llave: " + pe.getLlaveNecesaria());
        } catch (MazmorraException me) {
        } finally {
            System.out.println("El aventurero salio de la mazmorra");
        }

        Artanas.lanzarHechizo("");
        // - 💀 Poné el `catch (MazmorraException e)` **antes** que el `catch
        // (TrampaException e)`. ¿Qué dice el compilador?
        // no lo hice, pero como cualquiera de las dos sub exceciones pueden entrar, entonces no captura ninguna excepcion especifica y esto es un problema
        // - 📜 ¿Por qué el compilador te obliga a manejar `entrar(...)` pero no
        // `lanzarHechizo(...)`?
        // mmm porque lanzarHechizo es unchecked
    }

}
