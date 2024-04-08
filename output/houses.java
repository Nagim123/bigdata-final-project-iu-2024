// ORM class for table 'houses'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Mon Apr 08 16:34:29 MSK 2024
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

public class houses extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("house_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        houses.this.house_id = (Integer)value;
      }
    });
    setters.put("id_region", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        houses.this.id_region = (Integer)value;
      }
    });
    setters.put("street_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        houses.this.street_id = (Integer)value;
      }
    });
    setters.put("postal_code", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        houses.this.postal_code = (Integer)value;
      }
    });
    setters.put("building_type", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        houses.this.building_type = (Integer)value;
      }
    });
    setters.put("geo_lon", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        houses.this.geo_lon = (Double)value;
      }
    });
    setters.put("geo_lat", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        houses.this.geo_lat = (Double)value;
      }
    });
    setters.put("object_type", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        houses.this.object_type = (Integer)value;
      }
    });
  }
  public houses() {
    init0();
  }
  private Integer house_id;
  public Integer get_house_id() {
    return house_id;
  }
  public void set_house_id(Integer house_id) {
    this.house_id = house_id;
  }
  public houses with_house_id(Integer house_id) {
    this.house_id = house_id;
    return this;
  }
  private Integer id_region;
  public Integer get_id_region() {
    return id_region;
  }
  public void set_id_region(Integer id_region) {
    this.id_region = id_region;
  }
  public houses with_id_region(Integer id_region) {
    this.id_region = id_region;
    return this;
  }
  private Integer street_id;
  public Integer get_street_id() {
    return street_id;
  }
  public void set_street_id(Integer street_id) {
    this.street_id = street_id;
  }
  public houses with_street_id(Integer street_id) {
    this.street_id = street_id;
    return this;
  }
  private Integer postal_code;
  public Integer get_postal_code() {
    return postal_code;
  }
  public void set_postal_code(Integer postal_code) {
    this.postal_code = postal_code;
  }
  public houses with_postal_code(Integer postal_code) {
    this.postal_code = postal_code;
    return this;
  }
  private Integer building_type;
  public Integer get_building_type() {
    return building_type;
  }
  public void set_building_type(Integer building_type) {
    this.building_type = building_type;
  }
  public houses with_building_type(Integer building_type) {
    this.building_type = building_type;
    return this;
  }
  private Double geo_lon;
  public Double get_geo_lon() {
    return geo_lon;
  }
  public void set_geo_lon(Double geo_lon) {
    this.geo_lon = geo_lon;
  }
  public houses with_geo_lon(Double geo_lon) {
    this.geo_lon = geo_lon;
    return this;
  }
  private Double geo_lat;
  public Double get_geo_lat() {
    return geo_lat;
  }
  public void set_geo_lat(Double geo_lat) {
    this.geo_lat = geo_lat;
  }
  public houses with_geo_lat(Double geo_lat) {
    this.geo_lat = geo_lat;
    return this;
  }
  private Integer object_type;
  public Integer get_object_type() {
    return object_type;
  }
  public void set_object_type(Integer object_type) {
    this.object_type = object_type;
  }
  public houses with_object_type(Integer object_type) {
    this.object_type = object_type;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof houses)) {
      return false;
    }
    houses that = (houses) o;
    boolean equal = true;
    equal = equal && (this.house_id == null ? that.house_id == null : this.house_id.equals(that.house_id));
    equal = equal && (this.id_region == null ? that.id_region == null : this.id_region.equals(that.id_region));
    equal = equal && (this.street_id == null ? that.street_id == null : this.street_id.equals(that.street_id));
    equal = equal && (this.postal_code == null ? that.postal_code == null : this.postal_code.equals(that.postal_code));
    equal = equal && (this.building_type == null ? that.building_type == null : this.building_type.equals(that.building_type));
    equal = equal && (this.geo_lon == null ? that.geo_lon == null : this.geo_lon.equals(that.geo_lon));
    equal = equal && (this.geo_lat == null ? that.geo_lat == null : this.geo_lat.equals(that.geo_lat));
    equal = equal && (this.object_type == null ? that.object_type == null : this.object_type.equals(that.object_type));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof houses)) {
      return false;
    }
    houses that = (houses) o;
    boolean equal = true;
    equal = equal && (this.house_id == null ? that.house_id == null : this.house_id.equals(that.house_id));
    equal = equal && (this.id_region == null ? that.id_region == null : this.id_region.equals(that.id_region));
    equal = equal && (this.street_id == null ? that.street_id == null : this.street_id.equals(that.street_id));
    equal = equal && (this.postal_code == null ? that.postal_code == null : this.postal_code.equals(that.postal_code));
    equal = equal && (this.building_type == null ? that.building_type == null : this.building_type.equals(that.building_type));
    equal = equal && (this.geo_lon == null ? that.geo_lon == null : this.geo_lon.equals(that.geo_lon));
    equal = equal && (this.geo_lat == null ? that.geo_lat == null : this.geo_lat.equals(that.geo_lat));
    equal = equal && (this.object_type == null ? that.object_type == null : this.object_type.equals(that.object_type));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.house_id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.id_region = JdbcWritableBridge.readInteger(2, __dbResults);
    this.street_id = JdbcWritableBridge.readInteger(3, __dbResults);
    this.postal_code = JdbcWritableBridge.readInteger(4, __dbResults);
    this.building_type = JdbcWritableBridge.readInteger(5, __dbResults);
    this.geo_lon = JdbcWritableBridge.readDouble(6, __dbResults);
    this.geo_lat = JdbcWritableBridge.readDouble(7, __dbResults);
    this.object_type = JdbcWritableBridge.readInteger(8, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.house_id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.id_region = JdbcWritableBridge.readInteger(2, __dbResults);
    this.street_id = JdbcWritableBridge.readInteger(3, __dbResults);
    this.postal_code = JdbcWritableBridge.readInteger(4, __dbResults);
    this.building_type = JdbcWritableBridge.readInteger(5, __dbResults);
    this.geo_lon = JdbcWritableBridge.readDouble(6, __dbResults);
    this.geo_lat = JdbcWritableBridge.readDouble(7, __dbResults);
    this.object_type = JdbcWritableBridge.readInteger(8, __dbResults);
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
    JdbcWritableBridge.writeInteger(house_id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(id_region, 2 + __off, 5, __dbStmt);
    JdbcWritableBridge.writeInteger(street_id, 3 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(postal_code, 4 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(building_type, 5 + __off, 5, __dbStmt);
    JdbcWritableBridge.writeDouble(geo_lon, 6 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(geo_lat, 7 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeInteger(object_type, 8 + __off, 5, __dbStmt);
    return 8;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(house_id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(id_region, 2 + __off, 5, __dbStmt);
    JdbcWritableBridge.writeInteger(street_id, 3 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(postal_code, 4 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(building_type, 5 + __off, 5, __dbStmt);
    JdbcWritableBridge.writeDouble(geo_lon, 6 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(geo_lat, 7 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeInteger(object_type, 8 + __off, 5, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.house_id = null;
    } else {
    this.house_id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.id_region = null;
    } else {
    this.id_region = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.street_id = null;
    } else {
    this.street_id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.postal_code = null;
    } else {
    this.postal_code = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.building_type = null;
    } else {
    this.building_type = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.geo_lon = null;
    } else {
    this.geo_lon = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.geo_lat = null;
    } else {
    this.geo_lat = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.object_type = null;
    } else {
    this.object_type = Integer.valueOf(__dataIn.readInt());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.house_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.house_id);
    }
    if (null == this.id_region) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.id_region);
    }
    if (null == this.street_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.street_id);
    }
    if (null == this.postal_code) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.postal_code);
    }
    if (null == this.building_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.building_type);
    }
    if (null == this.geo_lon) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.geo_lon);
    }
    if (null == this.geo_lat) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.geo_lat);
    }
    if (null == this.object_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.object_type);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.house_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.house_id);
    }
    if (null == this.id_region) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.id_region);
    }
    if (null == this.street_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.street_id);
    }
    if (null == this.postal_code) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.postal_code);
    }
    if (null == this.building_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.building_type);
    }
    if (null == this.geo_lon) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.geo_lon);
    }
    if (null == this.geo_lat) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.geo_lat);
    }
    if (null == this.object_type) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.object_type);
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
    __sb.append(FieldFormatter.escapeAndEnclose(house_id==null?"null":"" + house_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(id_region==null?"null":"" + id_region, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(street_id==null?"null":"" + street_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(postal_code==null?"null":"" + postal_code, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(building_type==null?"null":"" + building_type, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(geo_lon==null?"null":"" + geo_lon, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(geo_lat==null?"null":"" + geo_lat, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(object_type==null?"null":"" + object_type, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(house_id==null?"null":"" + house_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(id_region==null?"null":"" + id_region, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(street_id==null?"null":"" + street_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(postal_code==null?"null":"" + postal_code, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(building_type==null?"null":"" + building_type, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(geo_lon==null?"null":"" + geo_lon, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(geo_lat==null?"null":"" + geo_lat, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(object_type==null?"null":"" + object_type, delimiters));
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
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.house_id = null; } else {
      this.house_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.id_region = null; } else {
      this.id_region = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.street_id = null; } else {
      this.street_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.postal_code = null; } else {
      this.postal_code = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.building_type = null; } else {
      this.building_type = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.geo_lon = null; } else {
      this.geo_lon = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.geo_lat = null; } else {
      this.geo_lat = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.object_type = null; } else {
      this.object_type = Integer.valueOf(__cur_str);
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
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.house_id = null; } else {
      this.house_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.id_region = null; } else {
      this.id_region = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.street_id = null; } else {
      this.street_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.postal_code = null; } else {
      this.postal_code = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.building_type = null; } else {
      this.building_type = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.geo_lon = null; } else {
      this.geo_lon = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.geo_lat = null; } else {
      this.geo_lat = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.object_type = null; } else {
      this.object_type = Integer.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    houses o = (houses) super.clone();
    return o;
  }

  public void clone0(houses o) throws CloneNotSupportedException {
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("house_id", this.house_id);
    __sqoop$field_map.put("id_region", this.id_region);
    __sqoop$field_map.put("street_id", this.street_id);
    __sqoop$field_map.put("postal_code", this.postal_code);
    __sqoop$field_map.put("building_type", this.building_type);
    __sqoop$field_map.put("geo_lon", this.geo_lon);
    __sqoop$field_map.put("geo_lat", this.geo_lat);
    __sqoop$field_map.put("object_type", this.object_type);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("house_id", this.house_id);
    __sqoop$field_map.put("id_region", this.id_region);
    __sqoop$field_map.put("street_id", this.street_id);
    __sqoop$field_map.put("postal_code", this.postal_code);
    __sqoop$field_map.put("building_type", this.building_type);
    __sqoop$field_map.put("geo_lon", this.geo_lon);
    __sqoop$field_map.put("geo_lat", this.geo_lat);
    __sqoop$field_map.put("object_type", this.object_type);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
