// ORM class for table 'real_estate_announcements'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Tue Apr 16 01:25:27 MSK 2024
// For connector: org.apache.sqoop.manager.PostgresqlManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import org.apache.sqoop.lib.JdbcWritableBridge;
import org.apache.sqoop.lib.DelimiterSet;
import org.apache.sqoop.lib.FieldFormatter;
import org.apache.sqoop.lib.RecordParser;
import org.apache.sqoop.lib.BooleanParser;
import org.apache.sqoop.lib.BlobRef;
import org.apache.sqoop.lib.ClobRef;
import org.apache.sqoop.lib.LargeObjectLoader;
import org.apache.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class real_estate_announcements extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("announcement_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        real_estate_announcements.this.announcement_id = (Integer)value;
      }
    });
    setters.put("publication_date", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        real_estate_announcements.this.publication_date = (java.sql.Date)value;
      }
    });
    setters.put("price", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        real_estate_announcements.this.price = (Long)value;
      }
    });
    setters.put("level", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        real_estate_announcements.this.level = (Integer)value;
      }
    });
    setters.put("levels", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        real_estate_announcements.this.levels = (Integer)value;
      }
    });
    setters.put("rooms", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        real_estate_announcements.this.rooms = (Integer)value;
      }
    });
    setters.put("area", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        real_estate_announcements.this.area = (java.math.BigDecimal)value;
      }
    });
    setters.put("kitchen_area", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        real_estate_announcements.this.kitchen_area = (java.math.BigDecimal)value;
      }
    });
    setters.put("house_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        real_estate_announcements.this.house_id = (Integer)value;
      }
    });
  }
  public real_estate_announcements() {
    init0();
  }
  private Integer announcement_id;
  public Integer get_announcement_id() {
    return announcement_id;
  }
  public void set_announcement_id(Integer announcement_id) {
    this.announcement_id = announcement_id;
  }
  public real_estate_announcements with_announcement_id(Integer announcement_id) {
    this.announcement_id = announcement_id;
    return this;
  }
  private java.sql.Date publication_date;
  public java.sql.Date get_publication_date() {
    return publication_date;
  }
  public void set_publication_date(java.sql.Date publication_date) {
    this.publication_date = publication_date;
  }
  public real_estate_announcements with_publication_date(java.sql.Date publication_date) {
    this.publication_date = publication_date;
    return this;
  }
  private Long price;
  public Long get_price() {
    return price;
  }
  public void set_price(Long price) {
    this.price = price;
  }
  public real_estate_announcements with_price(Long price) {
    this.price = price;
    return this;
  }
  private Integer level;
  public Integer get_level() {
    return level;
  }
  public void set_level(Integer level) {
    this.level = level;
  }
  public real_estate_announcements with_level(Integer level) {
    this.level = level;
    return this;
  }
  private Integer levels;
  public Integer get_levels() {
    return levels;
  }
  public void set_levels(Integer levels) {
    this.levels = levels;
  }
  public real_estate_announcements with_levels(Integer levels) {
    this.levels = levels;
    return this;
  }
  private Integer rooms;
  public Integer get_rooms() {
    return rooms;
  }
  public void set_rooms(Integer rooms) {
    this.rooms = rooms;
  }
  public real_estate_announcements with_rooms(Integer rooms) {
    this.rooms = rooms;
    return this;
  }
  private java.math.BigDecimal area;
  public java.math.BigDecimal get_area() {
    return area;
  }
  public void set_area(java.math.BigDecimal area) {
    this.area = area;
  }
  public real_estate_announcements with_area(java.math.BigDecimal area) {
    this.area = area;
    return this;
  }
  private java.math.BigDecimal kitchen_area;
  public java.math.BigDecimal get_kitchen_area() {
    return kitchen_area;
  }
  public void set_kitchen_area(java.math.BigDecimal kitchen_area) {
    this.kitchen_area = kitchen_area;
  }
  public real_estate_announcements with_kitchen_area(java.math.BigDecimal kitchen_area) {
    this.kitchen_area = kitchen_area;
    return this;
  }
  private Integer house_id;
  public Integer get_house_id() {
    return house_id;
  }
  public void set_house_id(Integer house_id) {
    this.house_id = house_id;
  }
  public real_estate_announcements with_house_id(Integer house_id) {
    this.house_id = house_id;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof real_estate_announcements)) {
      return false;
    }
    real_estate_announcements that = (real_estate_announcements) o;
    boolean equal = true;
    equal = equal && (this.announcement_id == null ? that.announcement_id == null : this.announcement_id.equals(that.announcement_id));
    equal = equal && (this.publication_date == null ? that.publication_date == null : this.publication_date.equals(that.publication_date));
    equal = equal && (this.price == null ? that.price == null : this.price.equals(that.price));
    equal = equal && (this.level == null ? that.level == null : this.level.equals(that.level));
    equal = equal && (this.levels == null ? that.levels == null : this.levels.equals(that.levels));
    equal = equal && (this.rooms == null ? that.rooms == null : this.rooms.equals(that.rooms));
    equal = equal && (this.area == null ? that.area == null : this.area.equals(that.area));
    equal = equal && (this.kitchen_area == null ? that.kitchen_area == null : this.kitchen_area.equals(that.kitchen_area));
    equal = equal && (this.house_id == null ? that.house_id == null : this.house_id.equals(that.house_id));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof real_estate_announcements)) {
      return false;
    }
    real_estate_announcements that = (real_estate_announcements) o;
    boolean equal = true;
    equal = equal && (this.announcement_id == null ? that.announcement_id == null : this.announcement_id.equals(that.announcement_id));
    equal = equal && (this.publication_date == null ? that.publication_date == null : this.publication_date.equals(that.publication_date));
    equal = equal && (this.price == null ? that.price == null : this.price.equals(that.price));
    equal = equal && (this.level == null ? that.level == null : this.level.equals(that.level));
    equal = equal && (this.levels == null ? that.levels == null : this.levels.equals(that.levels));
    equal = equal && (this.rooms == null ? that.rooms == null : this.rooms.equals(that.rooms));
    equal = equal && (this.area == null ? that.area == null : this.area.equals(that.area));
    equal = equal && (this.kitchen_area == null ? that.kitchen_area == null : this.kitchen_area.equals(that.kitchen_area));
    equal = equal && (this.house_id == null ? that.house_id == null : this.house_id.equals(that.house_id));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.announcement_id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.publication_date = JdbcWritableBridge.readDate(2, __dbResults);
    this.price = JdbcWritableBridge.readLong(3, __dbResults);
    this.level = JdbcWritableBridge.readInteger(4, __dbResults);
    this.levels = JdbcWritableBridge.readInteger(5, __dbResults);
    this.rooms = JdbcWritableBridge.readInteger(6, __dbResults);
    this.area = JdbcWritableBridge.readBigDecimal(7, __dbResults);
    this.kitchen_area = JdbcWritableBridge.readBigDecimal(8, __dbResults);
    this.house_id = JdbcWritableBridge.readInteger(9, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.announcement_id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.publication_date = JdbcWritableBridge.readDate(2, __dbResults);
    this.price = JdbcWritableBridge.readLong(3, __dbResults);
    this.level = JdbcWritableBridge.readInteger(4, __dbResults);
    this.levels = JdbcWritableBridge.readInteger(5, __dbResults);
    this.rooms = JdbcWritableBridge.readInteger(6, __dbResults);
    this.area = JdbcWritableBridge.readBigDecimal(7, __dbResults);
    this.kitchen_area = JdbcWritableBridge.readBigDecimal(8, __dbResults);
    this.house_id = JdbcWritableBridge.readInteger(9, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(announcement_id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeDate(publication_date, 2 + __off, 91, __dbStmt);
    JdbcWritableBridge.writeLong(price, 3 + __off, -5, __dbStmt);
    JdbcWritableBridge.writeInteger(level, 4 + __off, 5, __dbStmt);
    JdbcWritableBridge.writeInteger(levels, 5 + __off, 5, __dbStmt);
    JdbcWritableBridge.writeInteger(rooms, 6 + __off, 5, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(area, 7 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(kitchen_area, 8 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeInteger(house_id, 9 + __off, 4, __dbStmt);
    return 9;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(announcement_id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeDate(publication_date, 2 + __off, 91, __dbStmt);
    JdbcWritableBridge.writeLong(price, 3 + __off, -5, __dbStmt);
    JdbcWritableBridge.writeInteger(level, 4 + __off, 5, __dbStmt);
    JdbcWritableBridge.writeInteger(levels, 5 + __off, 5, __dbStmt);
    JdbcWritableBridge.writeInteger(rooms, 6 + __off, 5, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(area, 7 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeBigDecimal(kitchen_area, 8 + __off, 2, __dbStmt);
    JdbcWritableBridge.writeInteger(house_id, 9 + __off, 4, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.announcement_id = null;
    } else {
    this.announcement_id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.publication_date = null;
    } else {
    this.publication_date = new Date(__dataIn.readLong());
    }
    if (__dataIn.readBoolean()) { 
        this.price = null;
    } else {
    this.price = Long.valueOf(__dataIn.readLong());
    }
    if (__dataIn.readBoolean()) { 
        this.level = null;
    } else {
    this.level = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.levels = null;
    } else {
    this.levels = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.rooms = null;
    } else {
    this.rooms = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.area = null;
    } else {
    this.area = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.kitchen_area = null;
    } else {
    this.kitchen_area = org.apache.sqoop.lib.BigDecimalSerializer.readFields(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.house_id = null;
    } else {
    this.house_id = Integer.valueOf(__dataIn.readInt());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.announcement_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.announcement_id);
    }
    if (null == this.publication_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.publication_date.getTime());
    }
    if (null == this.price) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.price);
    }
    if (null == this.level) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.level);
    }
    if (null == this.levels) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.levels);
    }
    if (null == this.rooms) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.rooms);
    }
    if (null == this.area) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.area, __dataOut);
    }
    if (null == this.kitchen_area) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.kitchen_area, __dataOut);
    }
    if (null == this.house_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.house_id);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.announcement_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.announcement_id);
    }
    if (null == this.publication_date) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.publication_date.getTime());
    }
    if (null == this.price) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeLong(this.price);
    }
    if (null == this.level) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.level);
    }
    if (null == this.levels) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.levels);
    }
    if (null == this.rooms) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.rooms);
    }
    if (null == this.area) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.area, __dataOut);
    }
    if (null == this.kitchen_area) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    org.apache.sqoop.lib.BigDecimalSerializer.write(this.kitchen_area, __dataOut);
    }
    if (null == this.house_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.house_id);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(announcement_id==null?"null":"" + announcement_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(publication_date==null?"null":"" + publication_date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(price==null?"null":"" + price, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(level==null?"null":"" + level, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(levels==null?"null":"" + levels, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(rooms==null?"null":"" + rooms, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(area==null?"null":area.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(kitchen_area==null?"null":kitchen_area.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(house_id==null?"null":"" + house_id, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(announcement_id==null?"null":"" + announcement_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(publication_date==null?"null":"" + publication_date, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(price==null?"null":"" + price, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(level==null?"null":"" + level, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(levels==null?"null":"" + levels, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(rooms==null?"null":"" + rooms, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(area==null?"null":area.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(kitchen_area==null?"null":kitchen_area.toPlainString(), delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(house_id==null?"null":"" + house_id, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.announcement_id = null; } else {
      this.announcement_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.publication_date = null; } else {
      this.publication_date = java.sql.Date.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.price = null; } else {
      this.price = Long.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.level = null; } else {
      this.level = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.levels = null; } else {
      this.levels = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.rooms = null; } else {
      this.rooms = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.area = null; } else {
      this.area = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.kitchen_area = null; } else {
      this.kitchen_area = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.house_id = null; } else {
      this.house_id = Integer.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.announcement_id = null; } else {
      this.announcement_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.publication_date = null; } else {
      this.publication_date = java.sql.Date.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.price = null; } else {
      this.price = Long.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.level = null; } else {
      this.level = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.levels = null; } else {
      this.levels = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.rooms = null; } else {
      this.rooms = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.area = null; } else {
      this.area = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.kitchen_area = null; } else {
      this.kitchen_area = new java.math.BigDecimal(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.house_id = null; } else {
      this.house_id = Integer.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    real_estate_announcements o = (real_estate_announcements) super.clone();
    o.publication_date = (o.publication_date != null) ? (java.sql.Date) o.publication_date.clone() : null;
    return o;
  }

  public void clone0(real_estate_announcements o) throws CloneNotSupportedException {
    o.publication_date = (o.publication_date != null) ? (java.sql.Date) o.publication_date.clone() : null;
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("announcement_id", this.announcement_id);
    __sqoop$field_map.put("publication_date", this.publication_date);
    __sqoop$field_map.put("price", this.price);
    __sqoop$field_map.put("level", this.level);
    __sqoop$field_map.put("levels", this.levels);
    __sqoop$field_map.put("rooms", this.rooms);
    __sqoop$field_map.put("area", this.area);
    __sqoop$field_map.put("kitchen_area", this.kitchen_area);
    __sqoop$field_map.put("house_id", this.house_id);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("announcement_id", this.announcement_id);
    __sqoop$field_map.put("publication_date", this.publication_date);
    __sqoop$field_map.put("price", this.price);
    __sqoop$field_map.put("level", this.level);
    __sqoop$field_map.put("levels", this.levels);
    __sqoop$field_map.put("rooms", this.rooms);
    __sqoop$field_map.put("area", this.area);
    __sqoop$field_map.put("kitchen_area", this.kitchen_area);
    __sqoop$field_map.put("house_id", this.house_id);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
