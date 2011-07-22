/**
 * Licensed to Cloudera, Inc. under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  Cloudera, Inc. licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.sqoop.lib;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.lib.db.DBWritable;

/**
 * Interface implemented by the classes generated by sqoop's orm.ClassWriter.
 */
public interface SqoopRecord extends Cloneable, DBWritable, Writable {
  void parse(CharSequence s) throws RecordParser.ParseError;
  void parse(Text s) throws RecordParser.ParseError;
  void parse(byte [] s) throws RecordParser.ParseError;
  void parse(char [] s) throws RecordParser.ParseError;
  void parse(ByteBuffer s) throws RecordParser.ParseError;
  void parse(CharBuffer s) throws RecordParser.ParseError;
  void loadLargeObjects(LargeObjectLoader objLoader)
      throws SQLException, IOException, InterruptedException;
  Object clone() throws CloneNotSupportedException;

  /**
   * Inserts the data in this object into the PreparedStatement, starting
   * at parameter 'offset'. 
   * @return the number of fields written to the statement.
   */
  int write(PreparedStatement stmt, int offset) throws SQLException;
}

