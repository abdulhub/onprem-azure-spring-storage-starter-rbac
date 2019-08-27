package com.springprojects.azure.springazurestorage;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

   @Value("blob://applicationdata/parameters.json")
   private Resource blobFile;

   @GetMapping(value = "/")
   public String readBlobFile() throws IOException {
      return StreamUtils.copyToString(
         this.blobFile.getInputStream(),
         Charset.defaultCharset()) + "\n";
   }

   
}
