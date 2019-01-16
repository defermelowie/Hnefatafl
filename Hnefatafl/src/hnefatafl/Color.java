package hnefatafl;
/**
 * Enum color defines the color that things can have 
 *
 */
public enum Color {
    WHITE {
 /**
 * returns oppisite color
 * @return black if color is white
 */
        public Color opposite(){
            return BLACK;
        }
    },
    BLACK {
/**
 * returns oppisite color
 * @return white if color is white
 */       
        public Color opposite(){
            return WHITE;
        }
    };

    abstract public Color opposite();
    
    
}
