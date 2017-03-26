/**
 * A FIFO (First-In First-Out) list "interface".
 * @author odahcam
 * @author anologicon
 */
public class Fifo {

    private int lista_int[];
    private String lista_string[];
    private int end;
    private int begin;
    private int length;

    public Fifo() {

        // this.length = args.length > 1 && args[0] != null ? args[0] : 20;
        this.length = 20;
        this.lista_int = new int[this.length];
        this.lista_string = new String[this.length];

        this.end = -1;
        this.begin = -1;

    }

    /**
     * Adds an employee to the list.
     * @method insert
     * @param {int} id : The employee ID number.
     * @param {String} name : The employee name.
     * @return {boolean} Returns true on success and false on failure.
     */
    public boolean insert(int id, String name) {

        int aux = (this.end + 1) % this.length;

        if (aux != this.begin) {

            this.end = aux;
            this.lista_int[aux] = id;
            this.lista_string[aux] = name;

            if (this.begin < 0) {
                this.begin = 0;
            }

            return true;
        }

        return false;
    }

    /**
     * @method remove
     * @return {boolean} Returns true on success and false on failure.
     */
    public boolean remove() {

        boolean output = false;

        if (this.begin >= 0) {

            if (this.begin == this.end) {
                this.begin = -1;
                this.end = -1;
            } else {
                this.begin = (this.begin + 1) % this.length;
            }

            output = true;
        }

        return output;
    }

    public void destroy() {
        this.begin = -1;
        this.end = -1;
    }

    /**
     * Show the list items.
     * @return {void} Returns nothing.
     */
    public void show() {

        if (this.begin == -1) {
            System.out.println("Fila Vazia!");
            return;
        }

        int aux = -1;

        do {

            ++aux;

            System.out.println("╠╦ " + this.lista_int[aux]);
            System.out.println("║╚ " + this.lista_string[aux]);

        } while (aux < this.end);
        System.out.println("\n\n --------------------------------" );
    }

    /**
     * Shows an employee name by it's index in the list.
     * @param {int} index : The employee index in list.
     * @return {void} Returns nothing.
     */
    public void show_in(int index) {
        int aux;

        if (this.begin == -1) {
            System.out.println("\nFila Vazia");
            return;
        }

        aux = 0;

        do {
          aux++;
          nr++;

          if (this.lista_int[aux] == index) {
            System.out.println("Nome: "+this.lista_string[aux]);
          }

        }while (aux < this.end);
    }
}