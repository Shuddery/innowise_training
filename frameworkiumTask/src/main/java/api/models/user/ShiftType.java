package api.models.user;

import lombok.Data;

@Data
public class ShiftType {
    public boolean day;
    public boolean evening;
    public boolean overnight;
    public boolean weekend;
    public boolean weekday;

    public static ShiftType generate() {
        ShiftType shiftType = new ShiftType();
        shiftType.setDay(true);
        shiftType.setEvening(false);
        shiftType.setOvernight(false);
        shiftType.setWeekend(false);
        shiftType.setWeekday(false);
        return shiftType;
    }
}