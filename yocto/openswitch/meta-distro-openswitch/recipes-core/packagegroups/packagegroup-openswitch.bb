DESCRIPTION = "Package groups for OpenSwitch applications"
LICENSE = "Apache-2.0"
PR = "r1"

#
# packages which content depend on MACHINE_FEATURES need to be MACHINE_ARCH
#
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = ' \
            packagegroup-ops \
            packagegroup-ops-base \
            packagegroup-ops-min \
            packagegroup-ops-min-debug \
            packagegroup-ops-core \
            '

RDEPENDS_packagegroup-ops-base = "\
    os-release \
    i2c-tools \
    mtd-utils \
    gptfdisk \
    packagegroup-base-serial \
    lttng-tools lttng-modules lttng-ust babeltrace \
    kexec kdump \
    rsyslog \
    iproute2 dhcp-client\
    vim \
    tzdata-posix \
    valgrind \
    valgrind-memcheck \
    valgrind-helgrind \
    sudo \
    pwauth \
    shadow \
    cronie \
    inetutils-ping inetutils-ping6 inetutils-hostname inetutils-ifconfig \
    inetutils-tftp inetutils-traceroute inetutils-ftp inetutils-telnet \
    xinetd \
    ops-init \
    virtual/switchd \
    ${@bb.utils.contains('MACHINE_FEATURES', 'ops-sim', 'ops-switchd-sim-plugin', '',d)} \
    ops-ovsdb \
    virtual/ops-hw-config \
    ops-cfgd ops-fand ops-ledd ops-pmd ops-powerd ops-sysd ops-tempd \
    ops-intfd ops-lacpd ops-lldpd ops-vland ops-arpmgrd \
    ops-script-utils \
    ops-cli ops-restd lighttpd \
    ops-portd ops-quagga \
    ops-aaa-utils \
    ops-bufmond \
"

RDEPENDS_packagegroup-ops-base_append_arm = "\
    u-boot-fw-utils \
    t32server\
    "

RDEPENDS_packagegroup-ops-min = "\
    python \
    python-pyroute2 \
    yaml-cpp \
    libevent \
    util-linux-uuidgen \
    iptables \
    "

RDEPENDS_packagegroup-ops-min-debug = "\
    file strace ldd tcpdump gdb gdbserver eglibc-thread-db \
    iperf ethtool tcf-agent nfs-utils-client \
    "

RDEPENDS_packagegroup-ops-core = "\
    "