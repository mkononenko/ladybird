/**
 * Autogenerated by Thrift Compiler (1.0.0-dev)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.myco.ladybird.common.exchange.endpoint;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (1.0.0-dev)", date = "2014-7-14")
public class CreateAccountRequest implements org.apache.thrift.TBase<CreateAccountRequest, CreateAccountRequest._Fields>, java.io.Serializable, Cloneable, Comparable<CreateAccountRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CreateAccountRequest");

  private static final org.apache.thrift.protocol.TField ACCOUNT_INFO_FIELD_DESC = new org.apache.thrift.protocol.TField("accountInfo", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField PASSWORD_FIELD_DESC = new org.apache.thrift.protocol.TField("password", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new CreateAccountRequestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new CreateAccountRequestTupleSchemeFactory());
  }

  public AccountInfo accountInfo; // required
  public ByteBuffer password; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ACCOUNT_INFO((short)1, "accountInfo"),
    PASSWORD((short)2, "password");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ACCOUNT_INFO
          return ACCOUNT_INFO;
        case 2: // PASSWORD
          return PASSWORD;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ACCOUNT_INFO, new org.apache.thrift.meta_data.FieldMetaData("accountInfo", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, AccountInfo.class)));
    tmpMap.put(_Fields.PASSWORD, new org.apache.thrift.meta_data.FieldMetaData("password", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CreateAccountRequest.class, metaDataMap);
  }

  public CreateAccountRequest() {
  }

  public CreateAccountRequest(
    AccountInfo accountInfo,
    ByteBuffer password)
  {
    this();
    this.accountInfo = accountInfo;
    this.password = password;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public CreateAccountRequest(CreateAccountRequest other) {
    if (other.isSetAccountInfo()) {
      this.accountInfo = new AccountInfo(other.accountInfo);
    }
    if (other.isSetPassword()) {
      this.password = org.apache.thrift.TBaseHelper.copyBinary(other.password);
    }
  }

  public CreateAccountRequest deepCopy() {
    return new CreateAccountRequest(this);
  }

  @Override
  public void clear() {
    this.accountInfo = null;
    this.password = null;
  }

  public AccountInfo getAccountInfo() {
    return this.accountInfo;
  }

  public CreateAccountRequest setAccountInfo(AccountInfo accountInfo) {
    this.accountInfo = accountInfo;
    return this;
  }

  public void unsetAccountInfo() {
    this.accountInfo = null;
  }

  /** Returns true if field accountInfo is set (has been assigned a value) and false otherwise */
  public boolean isSetAccountInfo() {
    return this.accountInfo != null;
  }

  public void setAccountInfoIsSet(boolean value) {
    if (!value) {
      this.accountInfo = null;
    }
  }

  public byte[] getPassword() {
    setPassword(org.apache.thrift.TBaseHelper.rightSize(password));
    return password == null ? null : password.array();
  }

  public ByteBuffer bufferForPassword() {
    return password;
  }

  public CreateAccountRequest setPassword(byte[] password) {
    setPassword(password == null ? (ByteBuffer)null : ByteBuffer.wrap(password));
    return this;
  }

  public CreateAccountRequest setPassword(ByteBuffer password) {
    this.password = password;
    return this;
  }

  public void unsetPassword() {
    this.password = null;
  }

  /** Returns true if field password is set (has been assigned a value) and false otherwise */
  public boolean isSetPassword() {
    return this.password != null;
  }

  public void setPasswordIsSet(boolean value) {
    if (!value) {
      this.password = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ACCOUNT_INFO:
      if (value == null) {
        unsetAccountInfo();
      } else {
        setAccountInfo((AccountInfo)value);
      }
      break;

    case PASSWORD:
      if (value == null) {
        unsetPassword();
      } else {
        setPassword((ByteBuffer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ACCOUNT_INFO:
      return getAccountInfo();

    case PASSWORD:
      return getPassword();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ACCOUNT_INFO:
      return isSetAccountInfo();
    case PASSWORD:
      return isSetPassword();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof CreateAccountRequest)
      return this.equals((CreateAccountRequest)that);
    return false;
  }

  public boolean equals(CreateAccountRequest that) {
    if (that == null)
      return false;

    boolean this_present_accountInfo = true && this.isSetAccountInfo();
    boolean that_present_accountInfo = true && that.isSetAccountInfo();
    if (this_present_accountInfo || that_present_accountInfo) {
      if (!(this_present_accountInfo && that_present_accountInfo))
        return false;
      if (!this.accountInfo.equals(that.accountInfo))
        return false;
    }

    boolean this_present_password = true && this.isSetPassword();
    boolean that_present_password = true && that.isSetPassword();
    if (this_present_password || that_present_password) {
      if (!(this_present_password && that_present_password))
        return false;
      if (!this.password.equals(that.password))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_accountInfo = true && (isSetAccountInfo());
    list.add(present_accountInfo);
    if (present_accountInfo)
      list.add(accountInfo);

    boolean present_password = true && (isSetPassword());
    list.add(present_password);
    if (present_password)
      list.add(password);

    return list.hashCode();
  }

  @Override
  public int compareTo(CreateAccountRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetAccountInfo()).compareTo(other.isSetAccountInfo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAccountInfo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.accountInfo, other.accountInfo);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPassword()).compareTo(other.isSetPassword());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPassword()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.password, other.password);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("CreateAccountRequest(");
    boolean first = true;

    sb.append("accountInfo:");
    if (this.accountInfo == null) {
      sb.append("null");
    } else {
      sb.append(this.accountInfo);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("password:");
    if (this.password == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.password, sb);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (accountInfo != null) {
      accountInfo.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class CreateAccountRequestStandardSchemeFactory implements SchemeFactory {
    public CreateAccountRequestStandardScheme getScheme() {
      return new CreateAccountRequestStandardScheme();
    }
  }

  private static class CreateAccountRequestStandardScheme extends StandardScheme<CreateAccountRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, CreateAccountRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ACCOUNT_INFO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.accountInfo = new AccountInfo();
              struct.accountInfo.read(iprot);
              struct.setAccountInfoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PASSWORD
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.password = iprot.readBinary();
              struct.setPasswordIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, CreateAccountRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.accountInfo != null) {
        oprot.writeFieldBegin(ACCOUNT_INFO_FIELD_DESC);
        struct.accountInfo.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.password != null) {
        oprot.writeFieldBegin(PASSWORD_FIELD_DESC);
        oprot.writeBinary(struct.password);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class CreateAccountRequestTupleSchemeFactory implements SchemeFactory {
    public CreateAccountRequestTupleScheme getScheme() {
      return new CreateAccountRequestTupleScheme();
    }
  }

  private static class CreateAccountRequestTupleScheme extends TupleScheme<CreateAccountRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, CreateAccountRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetAccountInfo()) {
        optionals.set(0);
      }
      if (struct.isSetPassword()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetAccountInfo()) {
        struct.accountInfo.write(oprot);
      }
      if (struct.isSetPassword()) {
        oprot.writeBinary(struct.password);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, CreateAccountRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.accountInfo = new AccountInfo();
        struct.accountInfo.read(iprot);
        struct.setAccountInfoIsSet(true);
      }
      if (incoming.get(1)) {
        struct.password = iprot.readBinary();
        struct.setPasswordIsSet(true);
      }
    }
  }

}
