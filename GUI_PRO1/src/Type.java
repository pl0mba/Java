public enum Type {
        FOrPASSENGERS(false, false, false, 50) {
            @Override
            public String toString() {
                return toStringbase+"passengers";
            }
        },MAIL(false,true,false,0){
            @Override
            public String toString() {
                return toStringbase+"postmail";
            }
        },RESTAURANT(true, false, false, 15){
            @Override
            public String toString(){
                return toStringbase+"eating";
            }
        },BASICFR(false, true, false, 0){
            @Override
            public String toString(){
                return toStringbase+"freight usage";
            }
        },HEAVYFR(false, true, false, 0){
            @Override
            public String toString(){
                return toStringbase+"heavy freight usage";
            }
        },REFRIG(true, true, false, 0){
            @Override
            public String toString(){
                return toStringbase+"frozen freigt";
            }
        },FOrLIQUID(false, true, false, 0){
            @Override
            public String toString(){
                return toStringbase+"liquid";
            }
        },FOrGAS(false, true, true, 0){
            @Override
            public String toString(){
                return toStringbase+"gas";
            }
        },FOrEXPLOSIVES(false, true,true,0){
            @Override
            public String toString(){
                return toStringbase+"explosive materials";
            }
        },FOrTOXIC(false, true, true, 0){
            @Override
            public String toString() {
                return toStringbase+"toxic materials";
            }
        },FOrLIQandTOX(false, true, true,0){
            @Override
            public String toString(){
                return toStringbase+"toxic and liquid materials";
            }
        };
        private final boolean isElectrified;
        private final boolean isShipper;
        private final boolean isDangerous;
        private final int numOfSeats;
        private static final String toStringbase = "This is a carriage for";
        private Type(boolean isElectrified, boolean isShipper, boolean isDangerous, int numOfSeats) {
            this.isElectrified = isElectrified;
            this.isShipper = isShipper;
            this.isDangerous = isDangerous;
            this.numOfSeats = numOfSeats;
        }
        public boolean isElectrified() {return isElectrified;}

        public boolean isShipper() {return isShipper;}

        public boolean isDangerous(){return isDangerous;}

        public int getNumOfSeats(){return numOfSeats;}
}
